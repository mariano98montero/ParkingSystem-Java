package com.example.parkingsystemjava.mvp.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.widget.Toast;
import com.example.parkingsystemjava.R;
import com.example.parkingsystemjava.fragments.SpacesSettingDialogFragment;
import com.example.parkingsystemjava.listener.ListenerDialogFragment;
import com.example.parkingsystemjava.mvp.contract.ParkingContract;
import com.example.parkingsystemjava.mvp.view.base.ActivityView;

public class ParkingView extends ActivityView implements ParkingContract.MainActivityView {

    public ParkingView(Activity activity) {
        super(activity);
    }

    @Override
    public void showDialogFragment(ListenerDialogFragment listenerDialogFragment) {
        SpacesSettingDialogFragment dialogFragment = SpacesSettingDialogFragment.newInstance(listenerDialogFragment);
        FragmentManager fragmentManager = getFragmentManager();
        dialogFragment.show(fragmentManager, "dialog_fragment_spaces_setting");
    }

    @Override
    public void showParkingLotsAvailable(String parkingLots) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, context.getString(R.string.main_activity_toast_set_parking_lots, parkingLots), Toast.LENGTH_LONG).show();
        }
    }
}
