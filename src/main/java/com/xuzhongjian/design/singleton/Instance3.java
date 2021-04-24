package com.xuzhongjian.design.singleton;

import java.util.Objects;

/**
 * 懒汉线程不安全
 *
 * @author zjxu97 at 3/1/21 4:52 PM
 */
public class Instance3 {

    private static Instance3 instance = null;

    private Instance3() {

    }

    public static Instance3 getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Instance3();
        }
        return instance;
    }
}
