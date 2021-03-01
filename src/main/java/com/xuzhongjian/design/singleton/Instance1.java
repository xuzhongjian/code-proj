package com.xuzhongjian.design.singleton;

/**
 * 静态内部类实现单例模式
 *
 * @author zjxu97 at 12/31/20 2:53 PM
 */
public class Instance1 {

    private static class InnerInstance {
        private static Instance1 instance = new Instance1();
    }

    private Instance1() {

    }

    public static Instance1 getInstance() {
        return InnerInstance.instance;
    }
}
