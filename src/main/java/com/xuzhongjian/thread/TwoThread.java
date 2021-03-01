package com.xuzhongjian.thread;

/**
 * 两个线程交替打印
 *
 * @author zjxu97 at 1/5/21 8:17 PM
 */
public class TwoThread {
    private static final Object o = new Object();
    private static volatile int i = 0;

    public static void main(String[] args) {
        new Thread(new Runner(), "a").start();
        new Thread(new Runner(), "b").start();
    }

    private static class Runner implements Runnable {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (true) {
                synchronized (o) {
                    try {
                        o.notify();
                        System.out.println(threadName);
                        o.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
