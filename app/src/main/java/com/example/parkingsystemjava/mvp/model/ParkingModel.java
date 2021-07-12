package com.example.parkingsystemjava.mvp.model;

import com.example.parkingsystemjava.database.ReservationDatabase;
import com.example.parkingsystemjava.mvp.contract.ParkingContract;

public class ParkingModel implements ParkingContract.MainActivityModel {
    private String parkingLotsAvailable;
    private ReservationDatabase database;

    public ParkingModel(ReservationDatabase database) {
        this.database = database;
    }

    @Override
    public void setParkingLots(String parkingLotsAvailable) {
        database.setParkingLots(parkingLotsAvailable);
    }

    @Override
    public String getParkingLots() {
        return database.getParkingLots();
    }
}
