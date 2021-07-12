package com.example.parkingsystemjava.mvp.contract;

import com.example.parkingsystemjava.entity.Reservation;
import com.example.parkingsystemjava.listener.ListenerDateTime;
import com.example.parkingsystemjava.utils.ReservationErrorCodes;
import java.util.Calendar;

public interface ParkingReservationContract {

    interface ParkingReservationPresenter {
        void showDatePicker(ListenerDateTime listenerDateTime, boolean dateSelector);
        void addReservation(Reservation reservation, int parkingLot);
        void setEntryDate(Calendar entryDate);
        void setExitDate(Calendar exitDate);
        boolean validateReservation(Reservation reservation, int parkingLot);
        void validateAndSaveReservation(String entryDate, String exitDate, String keyCode, String parkingLot);
    }

    interface ParkingReservationView {
        void showDatePicker(ListenerDateTime listenerDateTime, boolean dateSelector);
        void showEntryDateSelected(String date);
        void showExitDateSelected(String date);
        void showConfirmationMessage();
        void showOverlapMessage();
        void showEntryErrorMessage();
        void showExitErrorMessage();
        void showKeyErrorMessage();
        void showParkingLotErrorMessage();
        void closeScreen();
    }

    interface ParkingReservationModel {
        void addReservation(Reservation reservation, int parkingLot);
        ReservationErrorCodes validateReservation(Reservation reservation, int parkingLot);
    }
}
