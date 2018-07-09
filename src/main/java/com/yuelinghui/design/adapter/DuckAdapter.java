package com.yuelinghui.design.adapter;

public class DuckAdapter implements  Turkey {

    Duck duck;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        this.duck.quack();
    }

    @Override
    public void fly() {
        this.duck.fly();
    }
}
