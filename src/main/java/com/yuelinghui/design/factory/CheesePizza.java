package com.yuelinghui.design.factory;

public class CheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("CheesePizza->prepare");
    }

    @Override
    public void make() {
        System.out.println("CheesePizza->make");
    }

    @Override
    public void cut() {
        System.out.println("CheesePizza->cut");
    }
}
