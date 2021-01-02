package com.xuzhongjian.model;

/**
 * 静态内部类实现单例模式
 *
 * @author zjxu97 at 12/31/20 2:53 PM
 */
public class Instance {

    private static class InnerInstance {
        private static Instance instance = new Instance();
    }

    private Instance() {

    }

    public static Instance getInstance() {
        return InnerInstance.instance;
    }
}
