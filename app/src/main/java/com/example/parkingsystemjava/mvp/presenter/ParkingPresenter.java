package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.listener.ListenerDialogFragment;
import com.example.parkingsystemjava.mvp.contract.ParkingContract;

public class ParkingPresenter implements ParkingContract.MainActivityPresenter {

    private final ParkingContract.MainActivityModel model;
    private final ParkingContract.MainActivityView view;

    public ParkingPresenter(ParkingContract.MainActivityModel model, ParkingContract.MainActivityView view) {
        this.model = model;
        this.view = view;
    }

    public void onSetParkingButtonPressed(ListenerDialogFragment listenerDialogFragment) {
        view.showDialogFragment(listenerDialogFragment);
    }

    @Override
    public void onReservationButtonPressed() {
        view.showReservationActivity();
    }

    @Override
    public void setParkingSpacesAvailable(String spacesAvailable) {
        model.setParkingLots(spacesAvailable);
        view.showParkingLotsAvailable(model.getParkingLots());
    }

    @Override
    public void deleteOldReservations() {
        model.deleteOldReservations();
        view.showDeletedOldReservationsMessage();
    }
}
