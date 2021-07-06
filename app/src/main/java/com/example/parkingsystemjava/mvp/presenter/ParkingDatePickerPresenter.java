package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.listener.ListenerDateTime;
import com.example.parkingsystemjava.mvp.contract.ParkingDatePickerContract;

public class ParkingDatePickerPresenter implements ParkingDatePickerContract.ParkingDatePickerPresenter {

    private final ParkingDatePickerContract.ParkingDatePickerView view;

    public ParkingDatePickerPresenter(ParkingDatePickerContract.ParkingDatePickerView parkingDatePickerView) {
        this.view = parkingDatePickerView;
    }

    @Override
    public void onButtonDialogFragmentDatePickerConfirmationPressed(ListenerDateTime listenerDateTime) {
        view.showReservationDate(listenerDateTime);
    }

    @Override
    public void closeDateDialog() {
        view.closeDateDialog();
    }
}
