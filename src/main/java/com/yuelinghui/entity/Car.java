package com.yuelinghui.entity;

import java.io.Serializable;

public class Car implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 42342L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Car){
            return (this.name == ((Car)obj).name);
        } else {
            return false;
        }
    }
}