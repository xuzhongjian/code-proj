package com.xuzhongjian.design.singleton;

import java.util.Objects;

/**
 * 懒汉 线程安全
 *
 * @author zjxu97 at 3/1/21 4:54 PM
 */
public class Instance4 {
    private static Instance4 instance = null;

    private Instance4() {

    }

    public synchronized static Instance4 getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Instance4();
        }
        return instance;
    }
}
