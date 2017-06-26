package com.wjs.abstractFactoryPattern;

/**
 * Created by 341039 on 2017/3/22.\
 * 具体工厂类（纽约工厂类）
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory{

    public Dough createDough() {
        return new Dough();
    }

    public Sauce createSauce() {
        return new Sauce();
    }

    public Cheese createCheese() {
        return new Cheese();
    }

    public Veggies[] createVeggies() {
        return new Veggies[]{new Veggies()};
    }

    public Pepperoni createPepperoni() {
        return new Pepperoni();
    }

    public Clams createClams() {
        return new Clams();
    }
}
