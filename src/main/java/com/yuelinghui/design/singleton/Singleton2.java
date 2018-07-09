package com.yuelinghui.design.singleton;

public class Singleton2 {


    private static  Singleton2 sigleton ;

    private Singleton2() {}

    public synchronized  static Singleton2 getInstance() {
        long time = System.currentTimeMillis();
        if (sigleton == null) {
            synchronized (Singleton2.class) {
                if (sigleton == null) {
                    sigleton = new Singleton2();
                }
            }
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - time));
        return sigleton;
    }
}
