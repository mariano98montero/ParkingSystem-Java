package com.example.parkingsystemjava.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parkingsystemjava.databinding.ActivityReservationBinding;
import com.example.parkingsystemjava.mvp.contract.ParkingReservationContract;
import com.example.parkingsystemjava.mvp.presenter.ParkingReservationPresenter;
import com.example.parkingsystemjava.mvp.view.ParkingReservationView;

public class ReservationActivity extends AppCompatActivity {

    private ActivityReservationBinding binding;
    private ParkingReservationContract.ReservationActivityPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReservationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new ParkingReservationPresenter(new ParkingReservationView(this));

        setListeners();
    }

    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, ReservationActivity.class);
        return intent;
    }

    private void setListeners() {
        binding.editTextReservationActivityEntry.setOnClickListener(view -> presenter.showDatePicker());
        binding.editTextReservationActivityExit.setOnClickListener(view -> presenter.showDatePicker());
    }
}
