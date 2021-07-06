package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.entity.Reservation;
import com.example.parkingsystemjava.listener.ListenerDateTime;
import com.example.parkingsystemjava.mvp.contract.ParkingReservationContract;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ParkingReservationPresenter implements ParkingReservationContract.ParkingReservationPresenter {

    private static final String EMPTY_STRING = "";

    private ParkingReservationContract.ParkingReservationView view;
    private ParkingReservationContract.ParkingReservationModel model;

    public ParkingReservationPresenter(ParkingReservationContract.ParkingReservationModel model, ParkingReservationContract.ParkingReservationView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void showDatePicker(ListenerDateTime listenerDateTime) {
        view.showDatePicker(listenerDateTime);
    }

    @Override
    public void addReservation(Reservation reservation, int parkingLot) {
        model.addReservation(reservation, parkingLot);
        view.showConfirmationMessage(parkingLot);
    }

    @Override
    public void setEntryExitDate(Calendar date) {
        String stringDate = getStringFromDate(date);
        view.showDateSelected(stringDate);
    }

    private String getStringFromDate(Calendar calendar) {
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh: mm a dd-MMM-yyyy");
        String inActiveDate = EMPTY_STRING;
        try {
            inActiveDate = simpleDateFormat.format(date);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return inActiveDate;
    }
}
