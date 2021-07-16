package com.example.parkingsystemjava.mvp.model;

import com.example.parkingsystemjava.database.ReservationDatabase;
import com.example.parkingsystemjava.entity.Reservation;
import com.example.parkingsystemjava.mvp.contract.ParkingReservationContract;
import com.example.parkingsystemjava.utils.Constants;
import com.example.parkingsystemjava.utils.ReservationErrorCodes;
import java.util.Calendar;
import java.util.List;

public class ParkingReservationModel implements ParkingReservationContract.ParkingReservationModel {

    private ReservationDatabase database = null;

    public ParkingReservationModel(ReservationDatabase database) {
        this.database = database;
    }

    @Override
    public void addReservation(Reservation reservation, int parkingLot) {
        database.addReservation(reservation, parkingLot);
    }

    @Override
    public ReservationErrorCodes validateReservation(Reservation reservation, int parkingLot) {
        if (reservation.getEntryDate() == null) return ReservationErrorCodes.MISSING_ENTRY;
        if (reservation.getExitDate() == null) return ReservationErrorCodes.MISSING_EXIT;
        if (reservation.getKeyCode().isEmpty()) return ReservationErrorCodes.MISSING_KEYCODE;
        if (parkingLot < Constants.ZERO || parkingLot > Integer.parseInt(database.getParkingLots()))
            return ReservationErrorCodes.WRONG_PARKING_LOT;
        if (isOverlapping(reservation, parkingLot)) return ReservationErrorCodes.RESERVATION_OVERLAP;
        else return ReservationErrorCodes.OK;
    }

    @Override
    public void deleteOldReservations() {
        database.deleteOldReservations();
    }

    private boolean isOverlapping(Reservation reservation, int parkingLot) {
        List<Reservation> reservations = database.getReservations(parkingLot);
        Calendar reservationEntryDate = reservation.getEntryDate();
        Calendar reservationExitDate = reservation.getExitDate();
        boolean isOverlapping = false;
        int i = Constants.ZERO;
        if (reservations != null && reservations.size() > Constants.ZERO) {
            while (!isOverlapping && i < reservations.size()) {
                if (reservationEntryDate.before(reservations.get(i).getEntryDate()) &&
                        reservationExitDate.after(reservations.get(i).getEntryDate())) {
                    isOverlapping = true;
                } else if (reservationEntryDate.before(reservations.get(i).getExitDate()) &&
                        reservationExitDate.after(reservations.get(i).getExitDate())) {
                    isOverlapping = true;
                } else if (reservationEntryDate.after(reservations.get(i).getEntryDate()) &&
                        reservationExitDate.before(reservations.get(i).getExitDate())) {
                    isOverlapping = true;
                } else if (reservationEntryDate.equals(reservations.get(i).getEntryDate()) &&
                        reservationExitDate.equals(reservations.get(i).getExitDate())) {
                    isOverlapping = true;
                }
                i++;
            }
        }
        return isOverlapping;
    }
}
