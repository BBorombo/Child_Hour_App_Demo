package com.borombo.childhoursappdemo.singleton;

import com.borombo.childhoursappdemo.model.Profile;

import java.util.ArrayList;

/**
 * Created by Erwan on 18/11/2016.
 */
public class FakeData {

    private ArrayList<Profile> profiles = new ArrayList<>();

    private static FakeData instance = new FakeData();

    public static FakeData getInstance() {
        if (null == instance){
            instance = new FakeData();
        }
        return instance;
    }

    private FakeData() {

    }

    public ArrayList<Profile> getProfiles(){return this.profiles;}

    public Profile getById(int id){
        Profile resProfile = null;
        for (Profile p : profiles ) {
            if ( id == p.getId()){
                resProfile = p;
                break;
            }
        }
        return resProfile;
    }

    public void removeById(int id){
        for (Profile p : profiles ) {
            if (id == p.getId()){
                profiles.remove(p);
                break;
            }
        }
    }
}
