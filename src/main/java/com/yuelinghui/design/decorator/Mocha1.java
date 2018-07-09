package com.yuelinghui.design.decorator;

public class Mocha1 extends CondimentDecorator {

    Beverage beverage;

    public Mocha1(Beverage beverage) {
        this.beverage = beverage;
//        this.setSize(beverage.getSize());
    }

    @Override
    public double cost() {
        double cost;
        switch (getSize()) {
            case 1:
                cost =  0.2; break;
            case 2:
                cost =  0.3; break;
            default:
                cost = 0.4; break;
        }
        return beverage.cost() + cost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+"->Mocha1";
    }

    @Override
    public int getSize() {
        return beverage.getSize();
    }
}
