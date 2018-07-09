package com.yuelinghui.design.adapter;

public class Adapter1 implements Target {

    Adaptee adatee;


    public Adapter1(Adaptee adatee) {
       this.adatee = adatee;
    }

    @Override
    public void request() {
        adatee.specificRequest();
    }
}
