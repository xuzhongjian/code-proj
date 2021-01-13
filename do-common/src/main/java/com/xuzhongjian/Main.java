package com.xuzhongjian;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zjxu97 at 12/25/20 11:20 AM
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(10, 10,
                100L, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10, true));

        executorService.submit(()->{});

    }
}
