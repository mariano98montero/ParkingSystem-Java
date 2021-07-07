package com.example.parkingsystemjava.mvp.model;

import com.example.parkingsystemjava.database.ReservationDatabase;
import com.example.parkingsystemjava.entity.Reservation;
import com.example.parkingsystemjava.mvp.contract.ParkingReservationContract;

public class ParkingReservationModel implements ParkingReservationContract.ParkingReservationModel {

    private final ReservationDatabase database = ReservationDatabase.getInstance();
    private final Reservation reservation;

    public ParkingReservationModel() {
        this.reservation = new Reservation();
    }

    @Override
    public void addReservation(Reservation reservation, int parkingLot) {
        database.addReservation(reservation, parkingLot);
    }
}
