package com.yuelinghui;

import com.yuelinghui.entity.Car;
import com.yuelinghui.entity.Class;
import com.yuelinghui.entity.People;
import com.yuelinghui.entity.User;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Test {



    public static void main(String[] args) throws CloneNotSupportedException {
//        User user = new User();
//        user.setName("test");
//        Class c = new Class();
//        c.setName("test!");
//        user.setC(c);
//        User user1 = user;
//        User user2 = (User) user1.clone();
//
//
//        System.out.println(user.hashCode());
//        System.out.println(user1.hashCode());
//        System.out.println(user2.hashCode());
//        System.out.println(user2.equals(user1));
//        System.out.println(user.getC() == user2.getC());
//        Car car = new Car();
//        car.setName("benz");
//        People p = new People();
//        p.setCar(car);
//
//
//
//        try {
//            People p2 = p.deepClone();
//            People p3 = (People) p.clone();
//            System.out.println(p2.getCar() == p.getCar()); // false,说明引用的对象也进行了复制
//            System.out.println(p3.getCar() == p.getCar());
//        } catch (ClassNotFoundException | IOException e) {
//            e.printStackTrace();
//        }

        Car car = new Car();
        car.setName("benz");

        Car car1 = new Car();
        car1.setName("benz");

        Set<Car> set = new HashSet();
        set.add(car);
        set.add(car1);
        System.out.println(set.size());

    }
}
