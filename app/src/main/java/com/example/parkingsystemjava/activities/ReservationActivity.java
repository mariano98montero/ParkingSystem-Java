package com.example.parkingsystemjava.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parkingsystemjava.databinding.ActivityReservationBinding;
import com.example.parkingsystemjava.entity.Reservation;
import com.example.parkingsystemjava.listener.ListenerDateTime;
import com.example.parkingsystemjava.mvp.contract.ParkingReservationContract;
import com.example.parkingsystemjava.mvp.model.ParkingReservationModel;
import com.example.parkingsystemjava.mvp.view.ParkingReservationView;
import java.util.Calendar;

public class ReservationActivity extends AppCompatActivity implements ListenerDateTime {

    private ActivityReservationBinding binding;
    private ParkingReservationContract.ParkingReservationPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReservationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new com.example.parkingsystemjava.mvp.presenter.ParkingReservationPresenter(new ParkingReservationModel(), new ParkingReservationView(this, binding));

        setListeners();
    }

    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, ReservationActivity.class);
        return intent;
    }

    private void setListeners() {
        binding.editTextReservationActivityEntry.setOnClickListener(view -> presenter.showDatePicker(this));
        binding.editTextReservationActivityExit.setOnClickListener(view -> presenter.showDatePicker(this));
        binding.buttonReservationActivitySave.setOnClickListener(view -> makeReservation());
    }

    private void makeReservation() {
        Reservation reservation = new Reservation();
        reservation.setEntryDate(binding.editTextReservationActivityEntry.getText().toString());
        reservation.setExitDate(binding.editTextReservationActivityExit.getText().toString());
        reservation.setKeyCode(binding.editTextReservationActivityCode.getText().toString());
        int parkingLot = Integer.parseInt(binding.editTextReservationActivityParkingNumber.getText().toString());
        presenter.addReservation(reservation, parkingLot);
        finish();
    }

    @Override
    public void setEntryExitDate(Calendar entryExitDate) {
        presenter.setEntryExitDate(entryExitDate);
    }
}
