package com.example.parkingsystemjava.mvp.contract;

import com.example.parkingsystemjava.listener.ListenerDialogFragment;

public interface ParkingContract {

    interface MainActivityModel {
        void setParkingLots(String parkingLotsAvailable);
        String getParkingLots();
        void deleteOldReservations();
    }

    interface MainActivityPresenter {
        void onSetParkingButtonPressed(ListenerDialogFragment listenerDialogFragment);
        void onReservationButtonPressed();
        void setParkingSpacesAvailable(String spacesAvailable);
        void deleteOldReservations();
    }

    interface MainActivityView {
        void showDialogFragment(ListenerDialogFragment listenerDialogFragment);
        void showReservationActivity();
        void showParkingLotsAvailable(String parkingLots);
        void showDeletedOldReservationsMessage();
    }
}
