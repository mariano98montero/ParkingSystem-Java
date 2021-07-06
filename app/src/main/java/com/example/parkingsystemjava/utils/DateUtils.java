package com.example.parkingsystemjava.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static String getStringFromDate(Calendar calendar) {
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
        String inActiveDate = Constants.EMPTY_STRING;
        try {
            inActiveDate = simpleDateFormat.format(date);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return inActiveDate;
    }

    public static Calendar convertToCalendar(String dateString) {
        if (!dateString.isEmpty()) {
            Calendar calendar = Calendar.getInstance();
            Date date;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
            try {
                date = simpleDateFormat.parse(dateString);
                calendar.setTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return calendar;
        }
        return null;
    }
}
