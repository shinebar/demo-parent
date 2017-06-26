package com.wjs.abstractFactoryPattern;

/**
 * Created by 341039 on 2017/3/22.
 */
public class PepperoniPizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;
    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
        this.pizzaIngredientFactory=ingredientFactory;
    }

    @Override
    void prepare() {

    }
}
