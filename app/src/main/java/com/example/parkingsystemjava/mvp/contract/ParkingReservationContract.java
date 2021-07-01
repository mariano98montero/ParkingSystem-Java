package com.example.parkingsystemjava.mvp.contract;

public interface ParkingReservationContract {

    interface ReservationActivityPresenter {
        void showDatePicker();
    }

    interface ReservationActivityView {
        void showEntryDatePicker();
    }

    interface ReservationActivityModel {
    }
}
