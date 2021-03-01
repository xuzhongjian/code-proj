package com.xuzhongjian.design.singleton;

import java.util.Objects;

/**
 * 双重校验的单例模式
 *
 * @author zjxu97 at 3/1/21 4:56 PM
 */
public class Instance5 {

    // 防止：当上一个线程还没有将实例完全初始化，后一个线程读取到的对象还没有完全初始化
    private static volatile Instance5 instance = null;

    private Instance5() {

    }

    public Instance5 getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (Instance5.class) {
                if (Objects.isNull(instance)) {
                    instance = new Instance5();
                }
            }
        }
        return instance;
    }
}
