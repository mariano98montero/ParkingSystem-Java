package com.example.parkingsystemjava.database;

import com.example.parkingsystemjava.entity.Reservation;
import java.util.ArrayList;
import java.util.HashMap;

public class ReservationDatabase {
    private static ReservationDatabase instance = null;
    private final HashMap<Integer, ArrayList<Reservation>> reservations = new HashMap<>();
    private int parkingLots;

    public static ReservationDatabase getInstance() {
        if (instance == null) {
            instance = new ReservationDatabase();
        }
        return instance;
    }

    public void addReservation(Reservation reservation, int parkingLot) {
        if (reservations.get(parkingLot) == null) {
            ArrayList<Reservation> reservationsList = new ArrayList<>();
            reservationsList.add(reservation);
            reservations.put(parkingLot, reservationsList);
        } else {
            reservations.get(parkingLot).add(reservation);
        }
    }

    public String getParkingLots() {
        return String.valueOf(parkingLots);
    }

    public ArrayList<Reservation> getReservations(int parkingLot) {
        return reservations.get(parkingLot);
    }

    public void setParkingLots(String parkingLots) {
        this.parkingLots = Integer.parseInt(parkingLots);
    }
}