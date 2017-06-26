package com.wjs.ObserverPattern;

/**
 * Created by 341039 on 2017/3/20.
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
