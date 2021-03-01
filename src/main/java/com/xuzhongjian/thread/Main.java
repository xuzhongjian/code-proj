package com.xuzhongjian.thread;

import com.xuzhongjian.thread.model.TestThread;

/**
 * @author zjxu97 at 1/3/21 1:11 AM
 */
public class Main {
    public static void main(String[] args) {
        TestThread thread = new TestThread();
        System.out.println("this is main thread");
        thread.start();
    }
}
