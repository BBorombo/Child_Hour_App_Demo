package com.borombo.childhoursappdemo.model;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.RealmList;
import io.realm.RealmObject;


/**
 * Created by Erwan on 11/11/2016.
 */

public class Profile extends RealmObject {

    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String name;
    private String phone;
    private String photo;
    private Boolean present;
    RealmList<DailyTimeSheet> timeSheets = new RealmList<>();

    public Profile() {
        id = count.incrementAndGet();
    }

    public Profile(String name) {
        id = count.incrementAndGet();
        this.name = name;
    }

    public Profile(String name, String phone) {
        id = count.incrementAndGet();
        this.name = name;
        this.phone = phone;
    }

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

