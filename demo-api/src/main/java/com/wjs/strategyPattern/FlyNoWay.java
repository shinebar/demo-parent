package com.wjs.strategyPattern;

/**
 * Created by 341039 on 2017/3/21.
 */
public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println(" i can't fly");
    }
}
