package com.yuelinghui.design.observer;

public class Test {

    public static void main(String[] args) throws InterruptedException {



        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay();
        weatherData.addObserver(currentConditionDisplay);
        weatherData.setMeasurements(1,2,3);

        Thread.sleep(2000);

        weatherData.setMeasurements(2,22,3);

        // 设计
    }
}
