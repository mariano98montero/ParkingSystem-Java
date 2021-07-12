package com.example.parkingsystemjava.mvp.contract;

import com.example.parkingsystemjava.listener.ListenerDateTime;

public interface ParkingDatePickerContract {

    interface ParkingDatePickerPresenter {
        void onButtonDialogFragmentDatePickerConfirmationPressed(ListenerDateTime listenerDateTime);
        void closeDateDialog();
    }

    interface ParkingDatePickerView {
        void showEntryReservationDate(ListenerDateTime listenerDateTime);
        void showExitReservationDate(ListenerDateTime listenerDateTime);
        void closeDateDialog();
    }
}
