package com.borombo.childhoursappdemo.pageradapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.borombo.childhoursappdemo.fragments.DailyHistoryFragment;
import com.borombo.childhoursappdemo.fragments.MensualHistoryFragment;

/**
 * Created by Erwan on 17/11/2016.
 */


/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {
            case 0:
                return DailyHistoryFragment.newInstance("","");
            case 1:
                return MensualHistoryFragment.newInstance("","");
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "AUJOURD'HUI";
            case 1:
                return "MENSUEL";
        }
        return null;
    }
}
