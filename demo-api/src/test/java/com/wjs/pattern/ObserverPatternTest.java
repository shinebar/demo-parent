package com.wjs.pattern;

import com.wjs.ObserverPattern.CurrentConditionsDisplay;
import com.wjs.ObserverPattern.ObserverPattern;

/**
 * Created by 341039 on 2017/3/20.
 * 测试观察者模式
 */
public class ObserverPatternTest {

    public static void main(String[] args) {
        ObserverPattern observerPattern=new ObserverPattern();
        CurrentConditionsDisplay currentConditionsDisplay=new CurrentConditionsDisplay(observerPattern);
        observerPattern.setTdp(80,65,2.0F);
        observerPattern.setTdp(81,66,6.0F);
        observerPattern.setTdp(83,64,5.0F);
    }
}
