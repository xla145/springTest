package com.yuelinghui.design.singleton;

class TestThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Singleton.getInstance());
    }
}