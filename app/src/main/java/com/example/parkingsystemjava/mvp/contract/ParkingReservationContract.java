package com.example.parkingsystemjava.mvp.contract;

import com.example.parkingsystemjava.entity.Reservation;
import com.example.parkingsystemjava.listener.ListenerDateTime;
import java.util.Calendar;

public interface ParkingReservationContract {

    interface ParkingReservationPresenter {
        void showDatePicker(ListenerDateTime listenerDateTime);
        void addReservation(Reservation reservation, int parkingLot);
        void setEntryExitDate(Calendar entryExitDate);
    }

    interface ParkingReservationView {
        void showDatePicker(ListenerDateTime listenerDateTime);
        void showDateSelected(String date);
        void showConfirmationMessage(int parkingLot);
    }

    interface ParkingReservationModel {
        void addReservation(Reservation reservation, int parkingLot);
    }
}
