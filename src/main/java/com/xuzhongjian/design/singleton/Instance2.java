package com.xuzhongjian.design.singleton;

/**
 * 饿汉 线程安全
 *
 * @author zjxu97 at 3/1/21 4:37 PM
 */
public class Instance2 {
    private static Instance2 instance = new Instance2();

    private Instance2() {
    }

    public Instance2 getInstance() {
        return instance;
    }
}
