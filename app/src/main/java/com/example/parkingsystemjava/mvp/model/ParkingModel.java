package com.example.parkingsystemjava.mvp.model;

import com.example.parkingsystemjava.mvp.contract.ParkingContract;

public class ParkingModel implements ParkingContract.MainActivityModel {
    private String parkingLotsAvailable;

    @Override
    public void setParkingLots(String parkingLotsAvailable) {
        this.parkingLotsAvailable = parkingLotsAvailable;
    }

    @Override
    public String getParkingLots() {
        return parkingLotsAvailable;
    }
}
