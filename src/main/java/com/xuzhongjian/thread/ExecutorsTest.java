package com.xuzhongjian.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author zjxu97 at 3/23/21 2:51 PM
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(10);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService newWorkStealingPool = Executors.newWorkStealingPool();
    }
}
