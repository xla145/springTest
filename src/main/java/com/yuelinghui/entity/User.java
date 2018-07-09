package com.yuelinghui.entity;

// 学生对象
public class User implements Cloneable {
    private String name;
    private Long id;
    // 课程引用
    private Class c;

    public Class getC() {
        return c;
    }

    public void setC(Class c) {
        this.c = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof User) {
            User user = (User) obj;
            if (this.id == user.getId() && this.getName() == user.getName()) {
                return true;
            }
            if (user.getId().equals(this.id)
                    && user.getName().equals(this.name)) {
                return true;
            }
            return false;
        } else
            return false;
    }

}