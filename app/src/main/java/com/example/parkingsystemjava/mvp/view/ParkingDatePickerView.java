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

    private Calendar getCalendar() {
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
        return calendar;
    }

    @Override
    public void showEntryReservationDate(ListenerDateTime listenerDateTime) {
        listenerDateTime.setEntryDate(getCalendar());
    }

    @Override
    public void showExitReservationDate(ListenerDateTime listenerDateTime) {
        listenerDateTime.setExitDate(getCalendar());
    }

    @Override
    public void closeDateDialog() {
        DateReservationDialogFragment fragment = (DateReservationDialogFragment) getFragment();
        if (fragment != null) {
            fragment.dismiss();
        }
    }
}
