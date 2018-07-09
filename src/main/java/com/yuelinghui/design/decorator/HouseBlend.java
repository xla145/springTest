package com.yuelinghui.design.decorator;

public class HouseBlend extends Beverage {

    public HouseBlend(){
        setDescription("HouseBlend");
    }



    @Override
    public double cost() {
        return 1.55;
    }
}
