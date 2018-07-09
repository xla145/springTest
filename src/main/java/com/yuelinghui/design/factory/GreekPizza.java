package com.yuelinghui.design.factory;

public class GreekPizza implements  Pizza {

    @Override
    public void prepare() {
        System.out.println("GreekPizza->prepare");
    }

    @Override
    public void make() {
        System.out.println("GreekPizza->make");
    }

    @Override
    public void cut() {
        System.out.println("GreekPizza->cut");
    }
}
