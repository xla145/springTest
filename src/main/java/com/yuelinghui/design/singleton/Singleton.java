package com.yuelinghui.design.singleton;

import java.util.Date;

public class Singleton {


    private static volatile Singleton sigleton ;

    private Singleton() {}

    public  static Singleton getInstance() {
        long time = System.currentTimeMillis();
        if (sigleton == null) {
            synchronized (Singleton.class) {
                if (sigleton == null) {
                    sigleton = new Singleton();
                }
            }
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - time));
        return sigleton;
    }
}
