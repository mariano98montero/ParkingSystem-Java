package com.example.parkingsystemjava.mvp.view;

import android.app.Fragment;
import com.example.parkingsystemjava.databinding.DialogFragmentDatePickerBinding;
import com.example.parkingsystemjava.fragments.DateReservationDialogFragment;
import com.example.parkingsystemjava.listener.ListenerDateTime;
import com.example.parkingsystemjava.mvp.contract.ParkingDatePickerContract;
import com.example.parkingsystemjava.mvp.view.base.FragmentView;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ParkingDatePickerView extends FragmentView implements ParkingDatePickerContract.ParkingDatePickerView {

    private final DialogFragmentDatePickerBinding binding;

    public ParkingDatePickerView(Fragment fragment, DialogFragmentDatePickerBinding binding) {
        super(fragment);
        this.binding = binding;
    }

    @Override
    public void showReservationDate(ListenerDateTime listenerDateTime) {
        DateReservationDialogFragment fragment = (DateReservationDialogFragment) getFragment();
        Calendar calendar = new GregorianCalendar();
        calendar.set(binding.datePickerDialogFragment.getYear(),
                binding.datePickerDialogFragment.getMonth(),
                binding.datePickerDialogFragment.getDayOfMonth(),
                binding.timePickerDialogFragment.getHour(),
                binding.timePickerDialogFragment.getMinute());
        if (fragment != null) {
            fragment.dismiss();
        }
        listenerDateTime.setEntryExitDate(calendar);
    }

    @Override
    public void closeDateDialog() {
        DateReservationDialogFragment fragment = (DateReservationDialogFragment) getFragment();
        if (fragment != null) {
            fragment.dismiss();
        }
    }
}
