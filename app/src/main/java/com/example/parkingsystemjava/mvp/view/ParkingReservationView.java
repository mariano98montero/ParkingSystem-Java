package com.example.parkingsystemjava.mvp.view;

import android.app.Activity;
import android.app.FragmentManager;
import com.example.parkingsystemjava.fragments.DateReservationDialogFragment;
import com.example.parkingsystemjava.mvp.contract.ParkingReservationContract;
import com.example.parkingsystemjava.mvp.view.base.ActivityView;

public class ParkingReservationView extends ActivityView implements ParkingReservationContract.ReservationActivityView {

    private static final String DIALOG_FRAGMENT_ENTRY_DATE_PICKER = "DIALOG_FRAGMENT_ENTRY_DATE_PICKER";

    public ParkingReservationView(Activity activity) {
        super(activity);
    }

    @Override
    public void showEntryDatePicker() {
        DateReservationDialogFragment entryReservationDialogFragment = DateReservationDialogFragment.newInstance();
        FragmentManager fragmentManager = getFragmentManager();
        entryReservationDialogFragment.show(fragmentManager, DIALOG_FRAGMENT_ENTRY_DATE_PICKER);
    }
}
