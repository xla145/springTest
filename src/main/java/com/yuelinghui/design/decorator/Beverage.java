package com.yuelinghui.design.decorator;

public abstract  class Beverage {

    private String  description = "Beverage";

    private int size;

    public abstract double cost();


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
