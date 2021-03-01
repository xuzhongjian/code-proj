package com.xuzhongjian.design.observe;

/**
 * 观察者的实现
 *
 * @author zjxu97 at 3/1/21 5:23 PM
 */
public class TrueObserver extends Observer {

    public TrueObserver(Subject subject) {
        this.setSubject(subject);
        subject.addObserver(this);
    }

    @Override
    public void action() {
        System.out.println("我观察到了变化");
    }
}
