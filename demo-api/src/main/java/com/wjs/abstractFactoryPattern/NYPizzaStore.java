package com.wjs.abstractFactoryPattern;

/**
 * Created by 341039 on 2017/3/22.
 */
public class NYPizzaStore extends PizzaStore {

    protected Pizza createPizza(String item) {
        Pizza pizza = null;
// 纽约店会用到纽约披萨原料工厂，由该原料工厂负责生产使用纽约风味披萨所需的原料
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (item.equals("cheese")) {
// 把工厂传递给每一个披萨，以便披萨能从工厂中取得原料
            pizza = new CheesePizza(ingredientFactory);
        } else if (item.equals("veggie")) {
            pizza = new VeggiePizza(ingredientFactory);
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
        } else if (item.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
        }
        return pizza;
    }
}