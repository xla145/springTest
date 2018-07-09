package com.yuelinghui.design.factory;

public abstract class PizzaSore {

    public final void  orderPizza(String type) {
        Pizza pizza = createPizzaFactory(type);
        pizza.cut();
        pizza.make();
        pizza.prepare();
    }

    abstract Pizza createPizzaFactory(String type);

}
