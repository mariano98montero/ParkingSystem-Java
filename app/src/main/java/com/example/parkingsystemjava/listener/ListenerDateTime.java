package com.example.parkingsystemjava.listener;

import java.io.Serializable;
import java.util.Calendar;

public interface ListenerDateTime extends Serializable {
    void setEntryExitDate(Calendar entryExitDate);
}
