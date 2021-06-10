package com.example.parkingsystemjava.mvp.model;

import com.example.parkingsystemjava.mvp.contract.ParkingContract;

public class ParkingModel implements ParkingContract.MainActivityModel {
    private int parkingLots = 0;

    @Override
    public void setParkingLots() {
        this.parkingLots = 6;
    }

    @Override
    public int getParkingLots() {
        return parkingLots;
    }
}
