package com.yuelinghui.design.singleton;

public class Singleton1 {


    private static Singleton1 sigleton ;

    private Singleton1() {}

    public  static Singleton1 getInstance() {
        long time = System.currentTimeMillis();
        if (sigleton == null) {
            sigleton = new Singleton1();
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - time));
        return sigleton;
    }
}
