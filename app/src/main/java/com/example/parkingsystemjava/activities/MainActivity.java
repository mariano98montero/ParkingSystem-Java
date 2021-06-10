package com.example.parkingsystemjava.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.parkingsystemjava.databinding.ActivityMainBinding;
import com.example.parkingsystemjava.listener.ListenerDialogFragment;
import com.example.parkingsystemjava.mvp.contract.ParkingContract;
import com.example.parkingsystemjava.mvp.model.ParkingModel;
import com.example.parkingsystemjava.mvp.presenter.ParkingPresenter;
import com.example.parkingsystemjava.mvp.view.ParkingView;

public class MainActivity extends AppCompatActivity implements ListenerDialogFragment {

    private ActivityMainBinding binding;
    private ParkingContract.MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new ParkingPresenter(new ParkingModel(), new ParkingView(this));

        setListeners();
    }

    private void setListeners() {
        binding.buttonMainActivitySelectParkingSpace.setOnClickListener(view -> presenter.onSetParkingButtonPressed(this));
    }

    @Override
    public void listenFreeSpaces(String freeSpaces) {
        presenter.setParkingSpacesAvailable(freeSpaces);
    }
}
