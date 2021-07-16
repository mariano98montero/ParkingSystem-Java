package com.example.parkingsystemjava.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parkingsystemjava.database.ReservationDatabase;
import com.example.parkingsystemjava.databinding.ActivityReservationBinding;
import com.example.parkingsystemjava.entity.Reservation;
import com.example.parkingsystemjava.listener.ListenerDateTime;
import com.example.parkingsystemjava.mvp.contract.ParkingReservationContract;
import com.example.parkingsystemjava.mvp.model.ParkingReservationModel;
import com.example.parkingsystemjava.mvp.presenter.ParkingReservationPresenter;
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
        presenter = new ParkingReservationPresenter(new ParkingReservationModel(ReservationDatabase.getInstance()), new ParkingReservationView(this, binding));

        setListeners();
    }

    public static Intent newInstance(Context context) {
        return new Intent(context, ReservationActivity.class);
    }

    private void setListeners() {
        binding.editTextReservationActivityEntry.setOnClickListener(view -> presenter.showDatePicker(this, true));
        binding.editTextReservationActivityExit.setOnClickListener(view -> presenter.showDatePicker(this, false));
        binding.buttonReservationActivitySave.setOnClickListener(view -> makeReservation());
    }

    private void makeReservation() {
        presenter.deleteOldReservations();
        presenter.validateAndSaveReservation(
                new Reservation(
                        binding.editTextReservationActivityEntry.getText().toString(),
                        binding.editTextReservationActivityExit.getText().toString(),
                        binding.editTextReservationActivityCode.getText().toString()),
                binding.editTextReservationActivityParkingNumber.getText().toString());
    }

    @Override
    public void setEntryDate(Calendar entryDate) {
        presenter.setEntryDate(entryDate);
    }

    @Override
    public void setExitDate(Calendar exitDate) {
        presenter.setExitDate(exitDate);
    }
}
