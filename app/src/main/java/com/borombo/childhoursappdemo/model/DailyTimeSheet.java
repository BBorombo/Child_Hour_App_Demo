package com.borombo.childhoursappdemo.model;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Erwan on 11/11/2016.
 */

public class DailyTimeSheet extends RealmObject {

    private int id;
    private int day;
    private int month;
    private int years;
    private int totalTime;

    private RealmList<Comming> commings = new RealmList<>();


}
