package com.example.parkingsystemjava.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parkingsystemjava.database.ReservationDatabase;
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

        presenter = new ParkingPresenter(new ParkingModel(ReservationDatabase.getInstance()), new ParkingView(this));

        setListeners();
    }

    private void setListeners() {
        binding.buttonMainActivitySelectParkingSpace.setOnClickListener(view -> presenter.onSetParkingButtonPressed(this));
        binding.buttonMainActivityReservation.setOnClickListener(view -> presenter.onReservationButtonPressed());
    }

    @Override
    public void listenFreeSpaces(String freeSpaces) {
        presenter.setParkingSpacesAvailable(freeSpaces);
    }
}
