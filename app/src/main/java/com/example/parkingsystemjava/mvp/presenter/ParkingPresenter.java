package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.mvp.contract.ParkingContract;

public class ParkingPresenter implements ParkingContract.MainActivityPresenter {

    private ParkingContract.MainActivityModel model;
    private ParkingContract.MainActivityView view;

    public ParkingPresenter(ParkingContract.MainActivityModel model, ParkingContract.MainActivityView view) {
        this.model = model;
        this.view = view;
    }

    public void onSetParkingButtonPressed() {
        model.setParkingLots();
        view.showParkingLotsAvailable(model.getParkingLots());
    }
}
