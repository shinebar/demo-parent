package com.wjs.pattern;

/**
 * Created by 341039 on 2017/3/20.
 * 单例模式
 */
public class Singleton {
    private  volatile  static  Singleton uniqueInstance;

    private Singleton(){}

    public static Singleton getInstance(){
        if (uniqueInstance==null){
            synchronized (Singleton.class){
                if (uniqueInstance==null){
                    uniqueInstance=new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
