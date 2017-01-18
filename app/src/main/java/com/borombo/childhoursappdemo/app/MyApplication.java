package com.borombo.childhoursappdemo.app;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Erwan on 18/01/2017.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
