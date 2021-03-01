package com.xuzhongjian.design.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjxu97 at 3/1/21 5:20 PM
 */
public class Subject {
    public List<Observer> observers = new ArrayList<>();

    private int state = 0;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.action();
        }
    }
}
