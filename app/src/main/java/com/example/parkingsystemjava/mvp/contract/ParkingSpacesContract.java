package com.example.parkingsystemjava.mvp.contract;

import com.example.parkingsystemjava.listener.ListenerDialogFragment;

public interface ParkingSpacesContract {

    interface ParkingSpacesDialogFragmentPresenter {
        void onButtonDialogFragmentSpacesSettingConfirmationPressed(String freeSpaces, ListenerDialogFragment listenerDialogFragment);
    }

    interface ParkingSpacesDialogFragmentView {
        void showParkingLotsAvailable(String parkingLots, ListenerDialogFragment listenerDialogFragment);
        void showInvalidValue();
    }
}
