package com.borombo.childhoursappdemo.Data;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;

import java.util.Locale;

/**
 * Created by Erwan on 18/11/2016.
 */

public class Constants {

    public static final String DATE_FORMAT ="dd_MM_yyyy_HH_mm";
    public static final String DAY_FORMAT ="dd MMMM yyyy";
    public static final String MONTH_FORMAT ="MMMM yyyy";
    public static final DateFormat SDF = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.FRENCH);
    public static final DateFormat DAY_SDF = new SimpleDateFormat(Constants.DAY_FORMAT, Locale.FRENCH);
    public static final DateFormat MONTH_SDF = new SimpleDateFormat(Constants.MONTH_FORMAT, Locale.FRENCH);
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

    public static String formatDayDate(String dayDate){
        String tmp[] = dayDate.split(" ");
        return tmp[0] + " " + Character.toString(tmp[1].charAt(0)).toUpperCase() + tmp[1].substring(1)+ " " + tmp[2];
    }

    public static String formatMonthDate(String dayDate){
        String tmp[] = dayDate.split(" ");
        return Character.toString(tmp[0].charAt(0)).toUpperCase() + tmp[0].substring(1)+ " " + tmp[1];
    }
}
