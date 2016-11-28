package com.borombo.childhoursappdemo.model;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Erwan on 11/11/2016.
 */

public class DailyTimeSheet extends RealmObject {

    private int id;
    private String day;
    private String month;
    private String years;
    private Time totalTime;

    private RealmList<Comming> commings = new RealmList<>();

    public DailyTimeSheet(){}

    public DailyTimeSheet(String dateTimeValues[]){
        this.day = dateTimeValues[0];
        this.month = dateTimeValues[1];
        this.years = dateTimeValues[2];
        commings.add(new Comming(dateTimeValues[3], dateTimeValues[4]));
        totalTime = new Time();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public Time getTotalTime() {
        for (Comming c: commings) {
            Time tmp = c.getTime();
            // Hours
            totalTime.setHours(totalTime.getHours() + tmp.getHours());
            // Minutes
            int mins = totalTime.getMinutes() + tmp.getMinutes();
            if (mins > 60){
                totalTime.setHours(totalTime.getHours() + 1);
                totalTime.setMinutes(mins - 60);
            }else if(mins == 60){
                totalTime.setHours(totalTime.getHours() + 1);
                totalTime.setMinutes(0);
            }else {
                totalTime.setMinutes(mins);
            }
        }

        return totalTime;
    }

    public RealmList<Comming> getCommings() {
        return commings;
    }

    public void setCommings(RealmList<Comming> commings) {
        this.commings = commings;
    }
}
