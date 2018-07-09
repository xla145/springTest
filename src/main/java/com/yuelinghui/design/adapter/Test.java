package com.yuelinghui.design.adapter;

public class Test {

    public static void main(String[] args) {

//        MallardDuck mallardDuck = new MallardDuck();
//
////        WildTurkey wildTurkey = new WildTurkey();
//////
//////        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(wildTurkey);
//////
//////        turkeyAdapter.fly();
//////
//////        turkeyAdapter.quack();
////
////        System.out.println("wildTurkey say ........");
//////        wildTurkey.fly();
//////        wildTurkey.gobble();
////        testTurkey(wildTurkey);
////
////
        MallardDuck mallardDuck = new MallardDuck();
////
////        System.out.println("MallardDuck say ........");
////        mallardDuck.fly();
////        mallardDuck.quack();
////
////
////
//        Turkey duckAdapter = new DuckAdapter(mallardDuck);
//        System.out.println("duckAdapter say ........");
//        testTurkey(duckAdapter);

//        Turkey duckAdapter1 = new DuckAdapter1();
//        duckAdapter1.gobble();
//        duckAdapter1.fly();



        Target target1 = new Adapter1(new Adaptee());
        target1.request();



        Target target = new Adaptees();
        target.request();

    }

    static void testTurkey(Turkey turkey) {
        turkey.fly();
        turkey.gobble();
    }
}
