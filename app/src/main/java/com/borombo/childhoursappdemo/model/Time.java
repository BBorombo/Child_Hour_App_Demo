package com.borombo.childhoursappdemo.model;

import io.realm.RealmObject;

/**
 * Created by Erwan on 18/11/2016.
 */

public class Time extends RealmObject {

    private int hours;
    private int minutes;

    public Time(){}

    public Time(String hours, String minutes){
        this.hours = Integer.valueOf(hours);
        this.minutes = Integer.valueOf(minutes);
    }

    public Time(int hours, int minutes){
        this.hours = hours;
        this.minutes = minutes;
    }

    public void setHours(int hours){this.hours = hours;}
    public void setMinutes(int minutes){this.minutes = minutes;}

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        if (0 == hours && 0 == minutes){
            res.append(" ND ");
        }else{
            if (0 == hours){
                res.append("0").append(hours);
            }else {
                res.append(hours);
            }
            res.append(" h ");
            if (minutes < 10){
                res.append("0").append(minutes);
            }else {
                res.append(minutes) ;
            }
        }
        return res.toString();
    }
}
