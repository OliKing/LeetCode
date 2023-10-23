package com.oliking.codejava.tran;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

    public static String nDatesBefore(int n, String format){
        DateFormat dateFormat = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -n);
        String time = dateFormat.format(calendar.getTime());
        return time;
    }
}
