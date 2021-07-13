package com.example.parkingsystemjava.database;

import com.example.parkingsystemjava.entity.Reservation;
import com.example.parkingsystemjava.utils.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class ReservationDatabase {
    private static ReservationDatabase instance = null;
    private final HashMap<Integer, List<Reservation>> reservations = new HashMap<>();
    private int parkingLots;

    public static ReservationDatabase getInstance() {
        if (instance == null) {
            instance = new ReservationDatabase();
        }
        return instance;
    }

    public void addReservation(Reservation reservation, int parkingLot) {
        if (reservations.get(parkingLot) == null) {
            List<Reservation> reservationsList = new ArrayList<>();
            reservationsList.add(reservation);
            reservations.put(parkingLot, reservationsList);
        } else {
            reservations.get(parkingLot).add(reservation);
        }
    }

    public String getParkingLots() {
        return String.valueOf(parkingLots);
    }

    public List<Reservation> getReservations(int parkingLot) {
        return reservations.get(parkingLot);
    }

    public void setParkingLots(String parkingLots) {
        this.parkingLots = Integer.parseInt(parkingLots);
    }

    public void deleteOldReservations() {
        Calendar today = Calendar.getInstance();
        int parkingLots = Integer.parseInt(this.getParkingLots());
        List<Reservation> reservations = new ArrayList<>();
        for (int indexParkingLots = Constants.ZERO; indexParkingLots <= parkingLots; indexParkingLots++) {
            if (this.getReservations(indexParkingLots) != null) {
                reservations.addAll(this.getReservations(indexParkingLots));
                for (int indexReservations = Constants.ZERO; indexReservations < reservations.size(); indexReservations++) {
                    if (reservations.get(indexReservations).getExitDate().before(today)) {
                        reservations.remove(reservations.get(indexReservations));
                    }
                }
            }
        }
    }
}
