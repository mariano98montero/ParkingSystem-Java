package com.example.parkingsystemjava.mvp.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.widget.Toast;
import androidx.annotation.StringRes;
import com.example.parkingsystemjava.R;
import com.example.parkingsystemjava.databinding.ActivityReservationBinding;
import com.example.parkingsystemjava.fragments.DateReservationDialogFragment;
import com.example.parkingsystemjava.listener.ListenerDateTime;
import com.example.parkingsystemjava.mvp.contract.ParkingReservationContract;
import com.example.parkingsystemjava.mvp.view.base.ActivityView;
import com.example.parkingsystemjava.utils.Constants;

public class ParkingReservationView extends ActivityView implements ParkingReservationContract.ParkingReservationView {

    private final ActivityReservationBinding binding;

    private final ActivityReservationBinding binding;

    public ParkingReservationView(Activity activity, ActivityReservationBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @Override
    public void showDatePicker(ListenerDateTime listenerDateTime, boolean dateSelector) {
        DateReservationDialogFragment entryReservationDialogFragment = DateReservationDialogFragment.newInstance(listenerDateTime, dateSelector);
        FragmentManager fragmentManager = getFragmentManager();
        entryReservationDialogFragment.show(fragmentManager, Constants.DIALOG_FRAGMENT_ENTRY_DATE_PICKER);
    }

    @Override
    public void showEntryDateSelected(String date) {
        binding.editTextReservationActivityEntry.setText(date);
    }

    @Override
    public void showExitDateSelected(String date) {
        binding.editTextReservationActivityExit.setText(date);
    }

    private void showMessage(@StringRes int messageId) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, messageId, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showOverlapMessage() {
        showMessage(R.string.reservation_activity_text_overlapping_error_message);
    }

    @Override
    public void showEntryErrorMessage() {
        showMessage(R.string.reservation_activity_text_entry_error_message);
    }

    @Override
    public void showExitErrorMessage() {
        showMessage(R.string.reservation_activity_text_exit_error_message);
    }

    @Override
    public void showKeyErrorMessage() {
        showMessage(R.string.reservation_activity_text_key_code_error_message);
    }

    @Override
    public void showParkingLotErrorMessage() {
        showMessage(R.string.reservation_activity_text_parking_lot_error_message);
    }

    @Override
    public void showConfirmationMessage() {
        showMessage(R.string.reservation_activity_text_confirmation_message);
    }

    @Override
    public void closeScreen() {
        Activity activity = getActivity();
        if (activity != null)
            activity.finish();
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
