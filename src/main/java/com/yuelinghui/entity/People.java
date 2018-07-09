package com.yuelinghui.entity;

import java.io.*;

// 深复制
public  class People implements Serializable, Cloneable {
    /**
     * 
     */
    private static final long serialVersionUID = 543535212412L;
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public People deepClone() throws IOException, ClassNotFoundException {
        // 腌制
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(this);
        // 取出
        ByteArrayInputStream input = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(input);
        return (People) ois.readObject();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}