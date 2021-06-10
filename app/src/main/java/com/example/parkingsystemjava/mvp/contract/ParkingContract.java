package com.example.parkingsystemjava.mvp.contract;

public interface ParkingContract {

    interface MainActivityModel {
        void setParkingLots();
        int getParkingLots();
    }

    interface MainActivityPresenter {
        void onSetParkingButtonPressed();
    }

    interface MainActivityView {
        void showParkingLotsAvailable(int parkingLots);
    }
}
