package com.xuzhongjian.design.singleton;

import java.util.Objects;

/**
 * 双重校验的单例模式
 *
 * @author zjxu97 at 3/1/21 4:56 PM
 */
public class Instance5 {

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
