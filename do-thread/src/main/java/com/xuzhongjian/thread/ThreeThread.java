package com.xuzhongjian.thread;

/**
 * @author zjxu97 at 1/5/21 8:48 PM
 */
public class ThreeThread {

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        new DemoThread(a, b, "a").start();
        new DemoThread(b, c, "b").start();
        new DemoThread(c, a, "c").start();
    }

    static class DemoThread extends Thread {

        private final Object cur;
        private final Object next;

        DemoThread(Object cur, Object next, String name) {
            this.cur = cur;
            this.next = next;
            this.setName(name);
        }


        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (next) {
                        synchronized (cur) {
                            System.out.print(Thread.currentThread().getName() + " ");
                            cur.notify();
                        }
                        Thread.sleep(10);
                        next.wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
