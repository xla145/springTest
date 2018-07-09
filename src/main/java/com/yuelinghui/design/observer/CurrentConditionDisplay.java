package com.yuelinghui.design.observer;

import com.yuelinghui.entity.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer,DisplayElement {

//    Observable observable;
    private int i ;
    private int j;

//    public CurrentConditionDisplay(Observable observable) {
////        this.observable = observable;
//        observable.addObserver(this);
//    }

    @Override
    public void display() {
        System.out.println("current:->i="+this.i+",j="+this.j);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof  WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.i = weatherData.getI();
            this.j = weatherData.getJ();
            display();
        }
    }
}
