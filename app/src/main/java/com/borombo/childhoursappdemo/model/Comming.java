package com.borombo.childhoursappdemo.model;

import io.realm.RealmObject;

/**
 * Created by Erwan on 11/11/2016.
 */

public class Comming extends RealmObject {

    private int id;
    private Time arrival;
    private Time departure = new Time();
    private Time time;

    public Comming() {}

    public Comming(String hours, String minutes) {
        arrival = new Time(hours,minutes);
    }

    public void setDeparture(String hours, String minutes){
        departure = new Time(hours,minutes);
        setTime();
    }

    private void setTime(){
        int hour = departure.getHours() - arrival.getHours();
        int min = Math.abs(departure.getMinutes() - arrival.getMinutes());
        time = new Time(hour, min);
    }

    public Time getTime() {
        if (null == time){

        }
        return time;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getArrival() {
        return arrival;
    }

    public void setArrival(Time arrival) {
        this.arrival = arrival;
        setTime();
    }

    public Time getDeparture() {
        return departure;
    }

    public void setDeparture(Time departure) {
        this.departure = departure;
        setTime();
    }

}
