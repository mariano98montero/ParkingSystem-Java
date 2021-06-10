package com.example.parkingsystemjava.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.parkingsystemjava.databinding.DialogFragmentParkingSpacesSettingBinding;
import com.example.parkingsystemjava.listener.ListenerDialogFragment;
import com.example.parkingsystemjava.mvp.contract.ParkingSpacesContract;
import com.example.parkingsystemjava.mvp.presenter.ParkingSpacesPresenter;
import com.example.parkingsystemjava.mvp.view.ParkingSpacesView;

public class SpacesSettingDialogFragment extends DialogFragment {

    private static final String LISTENER_KEY = "LISTENER_KEY";

    private DialogFragmentParkingSpacesSettingBinding binding;
    private ParkingSpacesContract.ParkingSpacesDialogFragmentPresenter presenter;
    private ListenerDialogFragment listenerDialogFragment;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new ParkingSpacesPresenter(new ParkingSpacesView(this));

        listenerDialogFragment = (ListenerDialogFragment) getArguments().getSerializable(LISTENER_KEY);
        setListeners();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DialogFragmentParkingSpacesSettingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private void setListeners() {
        binding.buttonDialogFragmentSpacesSettingConfirmation.setOnClickListener(view -> presenter.onButtonDialogFragmentSpacesSettingConfirmationPressed(binding.numberInputDialogFragmentParkingSpacesSetting.getText().toString(), listenerDialogFragment));
    }

    public static SpacesSettingDialogFragment newInstance(ListenerDialogFragment listenerDialogFragment) {
        SpacesSettingDialogFragment spacesSettingDialogFragment = new SpacesSettingDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(LISTENER_KEY, listenerDialogFragment);
        spacesSettingDialogFragment.setArguments(bundle);
        return spacesSettingDialogFragment;
    }
}
