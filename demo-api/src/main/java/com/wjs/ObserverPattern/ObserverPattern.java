package com.wjs.ObserverPattern;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 341039 on 2017/3/20.
 * 观察者模式
 */

public class ObserverPattern implements Subject {
    private ArrayList observers;
    private float temp;
    private float dudity;
    private float pressure;
    public ObserverPattern(){
        observers=new ArrayList();
    }
    public void registerObserver(Observer o) {
        observers.add(o);

    }

    public void removeObserver(Observer o) {
          if (observers.indexOf(o)!=-1){
              observers.remove(o);
          }
    }

    public void notifyObservers() {
        for (int it = 0;observers.size()>it; it++){
            ((Observer)observers.get(it)).update(temp,dudity,pressure);
        }
    }

    public void mChange(){
        notifyObservers();
    }

    public void setTdp(float temp,float humidity,float pressure){
        this.temp=temp;
        this.dudity=humidity;
        this.pressure=pressure;
        mChange();
    }
}
