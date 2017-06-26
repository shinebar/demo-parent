package com.wjs.abstractFactoryPattern;

/**
 * Created by 341039 on 2017/3/22.
 */
public class ClamPizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;
    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
      this.pizzaIngredientFactory=ingredientFactory;
    }

    @Override
    void prepare() {

    }
}
