package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.entity.Reservation;
import com.example.parkingsystemjava.listener.ListenerDateTime;
import com.example.parkingsystemjava.mvp.contract.ParkingReservationContract;
import com.example.parkingsystemjava.utils.Constants;
import com.example.parkingsystemjava.utils.DateUtils;
import com.example.parkingsystemjava.utils.ReservationErrorCodes;
import java.util.Calendar;

public class ParkingReservationPresenter implements ParkingReservationContract.ParkingReservationPresenter {

    private final ParkingReservationContract.ParkingReservationView view;
    private final ParkingReservationContract.ParkingReservationModel model;

    public ParkingReservationPresenter(ParkingReservationContract.ParkingReservationModel model, ParkingReservationContract.ParkingReservationView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void showDatePicker(ListenerDateTime listenerDateTime, boolean dateSelector) {
        view.showDatePicker(listenerDateTime, dateSelector);
    }

    @Override
    public void addReservation(Reservation reservation, int parkingLot) {
        model.addReservation(reservation, parkingLot);
    }

    @Override
    public void setEntryDate(Calendar date) {
        String stringDate = DateUtils.getStringFromDate(date);
        view.showEntryDateSelected(stringDate);
    }

    @Override
    public void setExitDate(Calendar date) {
        String stringDate = DateUtils.getStringFromDate(date);
        view.showExitDateSelected(stringDate);
    }

    @Override
    public boolean validateReservation(Reservation reservation, int parkingLot) {
        ReservationErrorCodes reservationCode = model.validateReservation(reservation, parkingLot);
        Boolean validation = false;
        switch (reservationCode) {
            case WRONG_PARKING_LOT:
                view.showParkingLotErrorMessage();
                validation = false;
                break;
            case RESERVATION_OVERLAP:
                view.showOverlapMessage();
                validation = false;
                break;
            case MISSING_ENTRY:
                view.showEntryErrorMessage();
                validation = false;
                break;
            case MISSING_EXIT:
                view.showExitErrorMessage();
                validation = false;
                break;
            case MISSING_KEYCODE:
                view.showKeyErrorMessage();
                validation = false;
                break;
            case OK:
                view.showConfirmationMessage();
                validation = true;
                break;
        }
        return validation;
    }

    @Override
    public void validateAndSaveReservation(Reservation reservation, String parkingLot) {
        int parkingLotInt;
        if (!parkingLot.isEmpty()) {
            parkingLotInt = Integer.parseInt(parkingLot);
        } else {
            parkingLotInt = Constants.MINUS_ONE;
        }
        if (validateReservation(reservation, parkingLotInt)) {
            addReservation(reservation, parkingLotInt);
            view.closeScreen();
        }
    }

    @Override
    public void deleteOldReservations() {
        model.deleteOldReservations();
        view.showOldReservationDeletionMessage();
    }
}
