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
import com.example.parkingsystemjava.utils.Constants;

public class DateReservationDialogFragment extends DialogFragment {

    private DialogFragmentDatePickerBinding binding;
    private ParkingDatePickerContract.ParkingDatePickerPresenter presenter;
    private ListenerDateTime listenerDateTime;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new ParkingDatePickerPresenter(new ParkingDatePickerView(this, binding), getArguments().getBoolean(Constants.DATE_SELECTOR_BOOLEAN));

        listenerDateTime = (ListenerDateTime) getArguments().getSerializable(Constants.LISTENER_DATE_PICKER_KEY);
        setListeners();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DialogFragmentDatePickerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public static DateReservationDialogFragment newInstance(ListenerDateTime listenerDateTime, boolean dateSelector) {
        DateReservationDialogFragment entryReservationDialogFragment = new DateReservationDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(Constants.DATE_SELECTOR_BOOLEAN, dateSelector);
        bundle.putSerializable(Constants.LISTENER_DATE_PICKER_KEY, listenerDateTime);
        entryReservationDialogFragment.setArguments(bundle);
        return entryReservationDialogFragment;
    }

    private void setListeners() {
        binding.buttonReservationDialogFragmentConfirm.setOnClickListener(view -> presenter.onButtonDialogFragmentDatePickerConfirmationPressed(listenerDateTime));
        binding.buttonReservationDialogFragmentCancel.setOnClickListener(view -> presenter.closeDateDialog());
    }
}
