package com.borombo.childhoursappdemo.Data;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;

/**
 * Created by Erwan on 18/11/2016.
 */

public class Constants {

    public static final String DATE_FORMAT ="dd_MM_yyyy_HH_mm";
    public static final DateFormat SDF = new SimpleDateFormat(Constants.DATE_FORMAT);
    public enum MONTH {Janvier,
        Février,
        Mars,
        Avril,
        Mai,
        Juin,
        Juillet,
        Aout,
        Septembre,
        Octobre,
        Novembre,
        Décembre}
}
