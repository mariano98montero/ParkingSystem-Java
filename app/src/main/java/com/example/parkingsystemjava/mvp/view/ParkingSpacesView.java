package com.example.parkingsystemjava.mvp.view;

import android.content.Context;
import android.widget.Toast;
import com.example.parkingsystemjava.R;
import com.example.parkingsystemjava.fragments.SpacesSettingDialogFragment;
import com.example.parkingsystemjava.listener.ListenerDialogFragment;
import com.example.parkingsystemjava.mvp.contract.ParkingSpacesContract;
import com.example.parkingsystemjava.mvp.view.base.FragmentView;

public class ParkingSpacesView extends FragmentView implements ParkingSpacesContract.ParkingSpacesDialogFragmentView {

    public ParkingSpacesView(SpacesSettingDialogFragment fragment) {
        super(fragment);
    }

    @Override
    public void showParkingLotsAvailable(String freeSpaces, ListenerDialogFragment listenerDialogFragment) {
        SpacesSettingDialogFragment fragment = (SpacesSettingDialogFragment) getFragment();
        if (fragment != null) {
            fragment.dismiss();
        }
        listenerDialogFragment.listenFreeSpaces(freeSpaces);
    }

    @Override
    public void showInvalidValue() {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, context.getString(R.string.dialog_fragment_toast_invalid_value), Toast.LENGTH_LONG).show();
        }
    }
}
