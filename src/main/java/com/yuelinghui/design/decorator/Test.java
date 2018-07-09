package com.yuelinghui.design.decorator;

import java.io.*;

public class Test {


    public static void main(String[] args) throws IOException {
        Beverage houseBlend = new HouseBlend();
        houseBlend.setSize(1);
        houseBlend= new Mocha(houseBlend);
        houseBlend = new Mocha1(houseBlend);
        System.out.println(houseBlend.getDescription()+",$->"+houseBlend.cost());
//        System.out.println("中".);

//        LowerCaseInputStream lowerCaseInputStream = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("g:/test.txt")));
//        int c = 0;
//        byte [] bytes = new byte[1024];
//        if ((c = lowerCaseInputStream.read(bytes,0,1024)) != -1) {
////            for (int i = 0; i < c; i++) {
//                System.out.println( new String(bytes));
////            }
//        }
    }
}
