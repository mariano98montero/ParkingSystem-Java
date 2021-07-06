package com.example.parkingsystemjava.entity;

import com.example.parkingsystemjava.utils.DateUtils;
import java.util.Calendar;

public class Reservation {

    private Calendar entryDate;
    private Calendar exitDate;
    private String keyCode;

    public Reservation() {
        this.entryDate = null;
        this.exitDate = null;
    }

    public Reservation(String entryDate, String exitDate, String keyCode) {
        this.entryDate = DateUtils.convertToCalendar(entryDate);
        this.exitDate = DateUtils.convertToCalendar(exitDate);
        this.keyCode = keyCode;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = DateUtils.convertToCalendar(entryDate);
    }

    public void setExitDate(String exitDate) {
        this.exitDate = DateUtils.convertToCalendar(exitDate);
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public Calendar getEntryDate() {
        return entryDate;
    }

    public Calendar getExitDate() {
        return exitDate;
    }

    public String getKeyCode() {
        return keyCode;
    }
}
