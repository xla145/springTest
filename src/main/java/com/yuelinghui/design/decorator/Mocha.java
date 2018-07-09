package com.yuelinghui.design.decorator;

public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        double cost;
        switch (getSize()) {
            case 1:
                cost =  0.1; break;
            case 2:
                cost =  0.2; break;
            default:
                cost = 0.3; break;
        }
        return beverage.cost() + cost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+"->Mocha";
    }

    @Override
    public int getSize() {
        return beverage.getSize();
    }
}
