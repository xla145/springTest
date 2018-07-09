package com.yuelinghui.design.adapter;

public class Adaptees extends Adaptee implements Target {

    @Override
    public void request() {
        super.specificRequest();
    }
}
