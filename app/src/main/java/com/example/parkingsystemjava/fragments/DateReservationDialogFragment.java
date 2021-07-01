package com.example.parkingsystemjava.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.parkingsystemjava.databinding.DialogFragmentDatePickerBinding;

public class DateReservationDialogFragment extends DialogFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        com.example.parkingsystemjava.databinding.DialogFragmentDatePickerBinding binding = DialogFragmentDatePickerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public static DateReservationDialogFragment newInstance() {
        DateReservationDialogFragment entryReservationDialogFragment = new DateReservationDialogFragment();
        Bundle bundle = new Bundle();
        entryReservationDialogFragment.setArguments(bundle);
        return entryReservationDialogFragment;
    }
}
