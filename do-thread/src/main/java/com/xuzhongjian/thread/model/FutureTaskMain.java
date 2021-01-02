package com.xuzhongjian.thread.model;

import java.util.concurrent.FutureTask;

/**
 * @author zjxu97 at 1/3/21 1:13 AM
 */
public class FutureTaskMain {
    public static void main(String[] args) {
        try {
            FutureTask<String> futureTask = new FutureTask<>(() -> {
                Thread.sleep(100);
                return "futureTask done";
            });

            Thread thread = new Thread(futureTask);
            thread.start();
            while (!futureTask.isDone()) {
                Thread.sleep(10);
                System.out.println("main waiting");
            }
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
