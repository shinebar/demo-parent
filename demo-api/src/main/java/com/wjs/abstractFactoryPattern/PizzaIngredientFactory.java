package com.wjs.abstractFactoryPattern;

/**
 * Created by 341039 on 2017/3/22.
 * 抽象工厂
 */
public interface PizzaIngredientFactory {
    // 在接口中，每个原料都有一个对应的方法创建该原料
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClams();

}
