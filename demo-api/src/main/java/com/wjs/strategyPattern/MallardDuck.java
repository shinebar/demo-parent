package com.wjs.strategyPattern;

/**
 * Created by 341039 on 2017/3/21.
 */
public class MallardDuck extends Duck {
    public MallardDuck(){
        quackBehavior=new Quack();
        flyBehavior=new FlyWithWings();
    }

    public void display() {
        System.out.println(" im a real Mallerd  duck");
    }
}
