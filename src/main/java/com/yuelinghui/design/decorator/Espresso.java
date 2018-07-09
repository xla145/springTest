package com.yuelinghui.design.decorator;

public class Espresso extends Beverage {

    public Espresso() {
        setDescription("Espresso");
    }

    @Override
    public double cost() {
        double cost;
        switch (getSize()) {
            case 1:
                cost =  1.69; break;
            case 2:
                cost =  1.68; break;
            default:
                cost = 1.54; break;
        }
        return cost;
    }
}
