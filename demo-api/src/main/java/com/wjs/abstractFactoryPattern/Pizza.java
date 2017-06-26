package com.wjs.abstractFactoryPattern;

/**
 * Created by 341039 on 2017/3/22.
 */
public  abstract class Pizza {
    String name;
    // 每个披萨都持有一组在准备时会用到的原料
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    // 现在把prepare()方法声明成抽象。在这个方法中，我们需要收集披萨所需的原料，而这些原料当然是来自原料工厂了。
    abstract void prepare();

    // 其他的方法保持不动
    void bake(){
        // ...
        System.out.println("bake");
    }

    void cut(){
        // ...
        System.out.println("cut");
    }

    void box(){
        // ...
        System.out.println("box");
    }
}
