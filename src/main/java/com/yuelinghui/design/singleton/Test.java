package com.yuelinghui.design.singleton;

public class Test {


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new TestThread());
        Thread thread1 = new Thread(new TestThread());
        Thread thread2 = new Thread(new TestThread());
        Thread thread3 = new Thread(new TestThread());
        thread.start();
        Thread.sleep(500);
        thread2.start();
        Thread.sleep(500);
        thread1.start();
        Thread.sleep(500);
        thread3.start();
    }
}
