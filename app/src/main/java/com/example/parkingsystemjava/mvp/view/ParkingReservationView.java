package com.example.parkingsystemjava.mvp.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.widget.Toast;
import com.example.parkingsystemjava.R;
import com.example.parkingsystemjava.databinding.ActivityReservationBinding;
import com.example.parkingsystemjava.fragments.DateReservationDialogFragment;
import com.example.parkingsystemjava.listener.ListenerDateTime;
import com.example.parkingsystemjava.mvp.contract.ParkingReservationContract;
import com.example.parkingsystemjava.mvp.view.base.ActivityView;

public class ParkingReservationView extends ActivityView implements ParkingReservationContract.ParkingReservationView {

    private static final String DIALOG_FRAGMENT_ENTRY_DATE_PICKER = "DIALOG_FRAGMENT_ENTRY_DATE_PICKER";

    private final ActivityReservationBinding binding;

    public ParkingReservationView(Activity activity, ActivityReservationBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @Override
    public void showDatePicker(ListenerDateTime listenerDateTime) {
        DateReservationDialogFragment entryReservationDialogFragment = DateReservationDialogFragment.newInstance(listenerDateTime);
        FragmentManager fragmentManager = getFragmentManager();
        entryReservationDialogFragment.show(fragmentManager, DIALOG_FRAGMENT_ENTRY_DATE_PICKER);
    }

    @Override
    public void showDateSelected(String date) {
        if (binding.editTextReservationActivityEntry.getText().toString().isEmpty()) {
            binding.editTextReservationActivityEntry.setText(date);
        } else {
            binding.editTextReservationActivityExit.setText(date);
        }
    }

    @Override
    public void showConfirmationMessage(int parkingLot) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, context.getString(R.string.reservation_activity_text_confirmation_message, parkingLot), Toast.LENGTH_LONG).show();
        }
    }
}
