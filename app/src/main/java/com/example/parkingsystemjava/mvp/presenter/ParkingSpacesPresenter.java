package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.listener.ListenerDialogFragment;
import com.example.parkingsystemjava.mvp.contract.ParkingSpacesContract;

public class ParkingSpacesPresenter implements ParkingSpacesContract.ParkingSpacesDialogFragmentPresenter {

    private final ParkingSpacesContract.ParkingSpacesDialogFragmentView view;

    public ParkingSpacesPresenter(ParkingSpacesContract.ParkingSpacesDialogFragmentView view) {
        this.view = view;
    }

    @Override
    public void onButtonDialogFragmentSpacesSettingConfirmationPressed(String freeSpaces, ListenerDialogFragment listenerDialogFragment) {
        if (freeSpaces.isEmpty()) {
            view.showInvalidValue();
        } else {
            view.showParkingLotsAvailable(freeSpaces, listenerDialogFragment);
        }
    }
}
