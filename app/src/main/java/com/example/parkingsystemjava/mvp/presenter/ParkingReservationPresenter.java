package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.mvp.contract.ParkingReservationContract;

public class ParkingReservationPresenter implements ParkingReservationContract.ReservationActivityPresenter {

    private ParkingReservationContract.ReservationActivityView view;

    public ParkingReservationPresenter(ParkingReservationContract.ReservationActivityView view) {
        this.view = view;
    }

    @Override
    public void showDatePicker() {
        view.showEntryDatePicker();
    }
}
