package com.xuzhongjian.design.observe;

import java.util.Random;

/**
 * @author zjxu97 at 3/1/21 5:20 PM
 */
public abstract class Observer {
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public abstract void action();
}
