package com.borombo.childhoursappdemo.model;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


/**
 * Created by Erwan on 11/11/2016.
 */

public class Profile extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;
    private String phone;
    private String photo;
    private Boolean present = false;
    private RealmList<DailyTimeSheet> timeSheets = new RealmList<>();

    public Profile() {}

    public DailyTimeSheet getDTSByDay(String day){
        String dayContent[] = day.split("_");
        for (DailyTimeSheet dts : timeSheets){
            if (dts.getDay().equals(dayContent[0]) && dts.getMonth().equals(dayContent[1]) && dts.getYears().equals(dayContent[2])){
                return dts;
            }
        }
        return null;
    }

    public ArrayList<DailyTimeSheet> getDTSByMonth(String month, String year){
        ArrayList<DailyTimeSheet> dailyTimeSheets = new ArrayList<>();
        for (DailyTimeSheet dts : timeSheets){
            if (dts.getMonth().equals(month) && dts.getYears().equals(year)){
                dailyTimeSheets.add(dts);
            }
        }
        return dailyTimeSheets;
    }

    public String totalByMonth(String month, String year){
        Time totalMonthTime = new Time();
        for (DailyTimeSheet dts : timeSheets){
            if (dts.getMonth().equals(month) && dts.getYears().equals(year)){
                Time tmp = dts.getTotalTime();
                // Hours
                totalMonthTime.setHours(totalMonthTime.getHours() + tmp.getHours());
                // Minutes
                int mins = totalMonthTime.getMinutes() + tmp.getMinutes();
                if (mins > 60){
                    totalMonthTime.setHours(totalMonthTime.getHours() + 1);
                    totalMonthTime.setMinutes(mins - 60);
                }else if(mins == 60){
                    totalMonthTime.setHours(totalMonthTime.getHours() + 1);
                    totalMonthTime.setMinutes(0);
                }else {
                    totalMonthTime.setMinutes(mins);
                }
            }
        }
        return totalMonthTime.toString();
    }

    /*public boolean isTDSForDate(String date){
        boolean res = false;

        return res;
    }*/

    public Boolean isPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }

    public RealmList<DailyTimeSheet> getTimeSheets() {
        return timeSheets;
    }

    public void setTimeSheets(RealmList<DailyTimeSheet> timeSheets) {
        this.timeSheets = timeSheets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}

