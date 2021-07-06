package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.listener.ListenerDateTime;
import com.example.parkingsystemjava.mvp.contract.ParkingDatePickerContract;

public class ParkingDatePickerPresenter implements ParkingDatePickerContract.ParkingDatePickerPresenter {

    private final ParkingDatePickerContract.ParkingDatePickerView view;
    private final boolean dateSelector;

    public ParkingDatePickerPresenter(ParkingDatePickerContract.ParkingDatePickerView parkingDatePickerView, boolean dateSelector) {
        this.view = parkingDatePickerView;
        this.dateSelector = dateSelector;
    }

    @Override
    public void onButtonDialogFragmentDatePickerConfirmationPressed(ListenerDateTime listenerDateTime) {
        if (dateSelector) {
            view.showEntryReservationDate(listenerDateTime);
        } else {
            view.showExitReservationDate(listenerDateTime);
        }
    }

    @Override
    public void closeDateDialog() {
        view.closeDateDialog();
    }
}
