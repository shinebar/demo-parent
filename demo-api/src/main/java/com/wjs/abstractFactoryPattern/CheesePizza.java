package com.wjs.abstractFactoryPattern;

/**
 * Created by 341039 on 2017/3/22.
 */
public class CheesePizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    void prepare() {
        // prepare()方法一步一步地创建芝士披萨，每当需要原料时，就跟工厂要。
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }
}
