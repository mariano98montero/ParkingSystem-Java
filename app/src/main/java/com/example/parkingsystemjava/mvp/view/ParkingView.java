package com.example.parkingsystemjava.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.example.parkingsystemjava.R;
import com.example.parkingsystemjava.databinding.ActivityMainBinding;
import com.example.parkingsystemjava.mvp.contract.ParkingContract;
import com.example.parkingsystemjava.mvp.view.base.ActivityView;

public class ParkingView extends ActivityView implements ParkingContract.MainActivityView {

    private final ActivityMainBinding binding;

    public ParkingView(Activity activity, ActivityMainBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @Override
    public void showParkingLotsAvailable(int parkingLots) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, context.getString(R.string.main_activity_toast_set_parking_lots, parkingLots), Toast.LENGTH_LONG).show();
        }
    }
}
