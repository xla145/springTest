package com.yuelinghui.design.adapter;

public class DuckAdapter1 extends MallardDuck implements Turkey {


    @Override
    public void gobble() {
        this.quack();
    }

    @Override
    public void fly() {
        super.fly();
    }
}
