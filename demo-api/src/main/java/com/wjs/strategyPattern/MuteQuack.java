package com.wjs.strategyPattern;

/**
 * Created by 341039 on 2017/3/21.
 */
public class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< silenc >>");
    }
}
