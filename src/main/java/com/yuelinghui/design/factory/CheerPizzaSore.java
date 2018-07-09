package com.yuelinghui.design.factory;

public class CheerPizzaSore extends PizzaSore {

    @Override
    Pizza createPizzaFactory(String type) {
        if (type.equals("cheese")) {
            return new CheesePizza();
        } else if ("greek".equals(type)) {
            return new  GreekPizza();
        }
        return null;
    }
}
