package com.example.parkingsystemjava.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.parkingsystemjava.databinding.DialogFragmentDatePickerBinding;
import com.example.parkingsystemjava.listener.ListenerDateTime;
import com.example.parkingsystemjava.mvp.contract.ParkingDatePickerContract;
import com.example.parkingsystemjava.mvp.presenter.ParkingDatePickerPresenter;
import com.example.parkingsystemjava.mvp.view.ParkingDatePickerView;

public class DateReservationDialogFragment extends DialogFragment {

    private static final String LISTENER_DATE_PICKER_KEY = "LISTENER_DATE_PICKER_KEY";

    private DialogFragmentDatePickerBinding binding;
    private ParkingDatePickerContract.ParkingDatePickerPresenter presenter;
    private ListenerDateTime listenerDateTime;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new ParkingDatePickerPresenter(new ParkingDatePickerView(this, binding));

        listenerDateTime = (ListenerDateTime) getArguments().getSerializable(LISTENER_DATE_PICKER_KEY);
        setListeners();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DialogFragmentDatePickerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public static DateReservationDialogFragment newInstance(ListenerDateTime listenerDateTime) {
        DateReservationDialogFragment entryReservationDialogFragment = new DateReservationDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(LISTENER_DATE_PICKER_KEY, listenerDateTime);
        entryReservationDialogFragment.setArguments(bundle);
        return entryReservationDialogFragment;
    }

    private void setListeners() {
        binding.buttonReservationDialogFragmentConfirm.setOnClickListener(view -> presenter.onButtonDialogFragmentDatePickerConfirmationPressed(listenerDateTime));
        binding.buttonReservationDialogFragmentCancel.setOnClickListener(view -> presenter.closeDateDialog());
    }
}
