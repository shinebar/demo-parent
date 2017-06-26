package com.wjs.pattern;

import com.wjs.strategyPattern.Duck;
import com.wjs.strategyPattern.MallardDuck;

/**
 * Created by 341039 on 2017/3/21.
 * 策略模式，少有继承，多用组合
 */
public class StrategyPatternTest {
    public static void main(String[] args) {
        Duck mallard=new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
        mallard.swim();
        mallard.display();

        String name="aware";
        System.out.println(name.intern());
    }
}
