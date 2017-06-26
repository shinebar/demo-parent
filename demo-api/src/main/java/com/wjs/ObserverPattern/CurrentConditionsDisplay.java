package com.wjs.ObserverPattern;

import org.apache.velocity.tools.generic.ClassTool;

/**
 * Created by 341039 on 2017/3/21.
 */
public class CurrentConditionsDisplay implements DisplayElement,Observer {
    private float temp;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }
    public void update(float temp, float humidity, float pressure) {
        this.temp=temp;
        this.humidity=humidity;
        display();
    }

    public void display() {
        System.out.println("current conditions "+temp+"F degree and "+humidity);
    }
}
