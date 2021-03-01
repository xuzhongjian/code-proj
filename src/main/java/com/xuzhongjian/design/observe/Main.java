package com.xuzhongjian.design.observe;

/**
 * @author zjxu97 at 3/1/21 5:43 PM
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new TrueObserver(subject);

        subject.setState(10);
    }
}
