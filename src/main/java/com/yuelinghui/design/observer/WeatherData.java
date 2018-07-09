package com.yuelinghui.design.observer;

import java.util.Observable;
import java.util.Observer;

public class WeatherData extends Observable{

    private int i ;
    private int j;
    private int g;

    public void changes() {
       setChanged();
       notifyObservers();
    }

    public void addConditionDisplay(Observer observer) {
        this.addObserver(observer);
    }

    public void setMeasurements(int i,int j,int g) {
        this.i = i;
        this.j = j;
        this.g = g;
        changes();
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }
}
