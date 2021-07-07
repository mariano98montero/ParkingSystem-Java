package com.example.parkingsystemjava.entity;

public class Reservation {

    private static final String EMPTY_STRING = "";

    private String entryDate;
    private String exitDate;
    private String keyCode;

    public Reservation() {
        this.entryDate = EMPTY_STRING;
        this.exitDate = EMPTY_STRING;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public String getEntryDate() {
        return entryDate;
    }
}
