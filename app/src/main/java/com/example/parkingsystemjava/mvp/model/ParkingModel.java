package com.example.parkingsystemjava.mvp.model;

import com.example.parkingsystemjava.database.ReservationDatabase;
import com.example.parkingsystemjava.entity.Reservation;
import com.example.parkingsystemjava.mvp.contract.ParkingContract;
import com.example.parkingsystemjava.utils.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ParkingModel implements ParkingContract.MainActivityModel {
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

    @Override
    public void deleteOldReservations() {
        Calendar today = Calendar.getInstance();
        int parkingLots = Integer.parseInt(database.getParkingLots());
        List<Reservation> reservations = new ArrayList<>();
        for (int indexParkingLots = Constants.ZERO; indexParkingLots <= parkingLots; indexParkingLots++) {
            if (database.getReservations(indexParkingLots) != null) {
                reservations.addAll(database.getReservations(indexParkingLots));
                for (int indexReservations = Constants.ZERO; indexReservations < reservations.size(); indexReservations++) {
                    if (reservations.get(indexReservations).getExitDate().before(today)) {
                        reservations.remove(reservations.get(indexReservations));
                    }
                }
            }
        }
    }
}
