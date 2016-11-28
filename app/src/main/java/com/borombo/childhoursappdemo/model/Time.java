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
        String res = "";
        if (0 == hours){
            res += "0"+hours;
        }else {
            res += hours;
        }
        res+= " h ";
        if (minutes < 10){
            res += "0"+minutes;
        }else {
            res += minutes;
        }

        return res;
    }
}
