package com.xuzhongjian;

import java.util.Random;
import java.util.UUID;

/**
 * @author zjxu97 at 3/2/21 11:09 AM
 */
public class Solution {

    private RedisOperation redis = new RedisOperation();
    private static final String KEY = "redis-lock-key";

    public static void main(String[] args) {
        Solution solution = new Solution();
        UUID uuid = UUID.randomUUID();
        String token = uuid.toString();
        try {
            if (solution.getRedisLock(token, 1000)) {
                System.out.println("hello world!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            solution.releaseLock(token);
        }

    }

    /**
     * 获取锁
     *
     * @param token   每个线程唯一的token
     * @param timeout 最大等待时间
     * @return 获取锁成功与否
     * @throws InterruptedException 中断异常
     */
    public boolean getRedisLock(String token, long timeout) throws InterruptedException {
        boolean success = false;
        long ts = System.currentTimeMillis();
        while (!success && System.currentTimeMillis() - ts < timeout) {
            success = redis.setnx(KEY, token);
            Thread.sleep(2);
        }
        return success;
    }

    /**
     * 释放锁
     *
     * @param token 和获取锁的时候一样，需要一个唯一的token来解锁，只有当唯一的token匹配上了，才能解锁。
     */
    public void releaseLock(String token) {
        String s = redis.get(KEY);
        if (token.equals(s)) {
            redis.del(KEY);
        }
    }
}

class RedisOperation {

    public RedisOperation() {
    }

    public boolean setnx(String key, String value) {
        return new Random().nextInt() % 2 == 0;
    }

    public String get(String key) {
        return "";
    }

    public boolean del(String key) {
        return new Random().nextInt() % 2 == 0;
    }
}