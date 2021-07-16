package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.database.ReservationDatabase;
import com.example.parkingsystemjava.entity.Reservation;
import com.example.parkingsystemjava.listener.ListenerDateTime;
import com.example.parkingsystemjava.mvp.contract.ParkingReservationContract;
import com.example.parkingsystemjava.mvp.model.ParkingReservationModel;
import com.example.parkingsystemjava.utils.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class ParkingReservationPresenterTest {
    private static final String KEY_CODE = "4321";
    private static final int YEAR = 2021;
    private static final int MONTH = 8;
    private static final int ENTRY_DAY = 16;
    private static final int HOUR = 1;
    private static final int MINUTE = 12;
    private static final int EXIT_DAY = 20;
    private static final int OLD_DAY = 1;
    private static final String PARKING_LOT = "12";
    private static final String EMPTY_STRING = "";
    private static final int MINUS_ONE = -1;
    private static final int PARKING_LOT_INT = 2;
    private ParkingReservationContract.ParkingReservationPresenter presenter;
    private ParkingReservationContract.ParkingReservationModel model;
    @Mock
    ParkingReservationContract.ParkingReservationView view;
    @Mock
    ListenerDateTime listenerDateTime;
    @Mock
    ReservationDatabase database;
    @Mock
    Reservation reservation;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        model = new ParkingReservationModel(database);
        presenter = new ParkingReservationPresenter(model, view);
    }

    private Calendar createEntryDateCalendar() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(YEAR, MONTH, ENTRY_DAY, HOUR, MINUTE);
        return calendar;
    }

    private Calendar createExitDateCalendar() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(YEAR, MONTH, EXIT_DAY, HOUR, MINUTE);
        return calendar;
    }

    @Test
    public void showDatePickerTest() {
        presenter.showDatePicker(listenerDateTime, true);

        verify(view).showDatePicker(listenerDateTime, true);
    }

    @Test
    public void addReservationTest() {
        presenter.addReservation(reservation, PARKING_LOT_INT);

        verify(database).addReservation(reservation, PARKING_LOT_INT);
    }

    @Test
    public void setEntryDayTest() {
        String date = DateUtils.getStringFromDate(createEntryDateCalendar());

        presenter.setEntryDate(createEntryDateCalendar());

        verify(view).showEntryDateSelected(date);
    }

    @Test
    public void setExitDayTest() {
        String date = DateUtils.getStringFromDate(createExitDateCalendar());

        presenter.setExitDate(createExitDateCalendar());

        verify(view).showExitDateSelected(date);
    }

    @Test
    public void validateReservationTestOk() {
        when(reservation.getEntryDate()).thenReturn(createEntryDateCalendar());
        when(reservation.getExitDate()).thenReturn(createExitDateCalendar());
        when(reservation.getKeyCode()).thenReturn(KEY_CODE);
        when(database.getParkingLots()).thenReturn(PARKING_LOT);

        presenter.validateReservation(reservation, PARKING_LOT_INT);

        verify(view).showConfirmationMessage();
    }

    @Test
    public void validateReservationTestErrorParkingLot() {
        when(reservation.getEntryDate()).thenReturn(createEntryDateCalendar());
        when(reservation.getExitDate()).thenReturn(createExitDateCalendar());
        when(reservation.getKeyCode()).thenReturn(KEY_CODE);

        presenter.validateReservation(reservation, MINUS_ONE);

        verify(view).showParkingLotErrorMessage();
    }

    @Test
    public void validateReservationTestErrorMissingEntry() {
        when(reservation.getEntryDate()).thenReturn(null);

        presenter.validateReservation(reservation, PARKING_LOT_INT);

        verify(view).showEntryErrorMessage();
    }

    @Test
    public void validateReservationTestErrorMissingExit() {
        when(reservation.getEntryDate()).thenReturn(createEntryDateCalendar());
        when(reservation.getExitDate()).thenReturn(null);

        presenter.validateReservation(reservation, PARKING_LOT_INT);

        verify(view).showExitErrorMessage();
    }

    @Test
    public void validateReservationTestErrorMissingKeyCode() {
        when(reservation.getEntryDate()).thenReturn(createEntryDateCalendar());
        when(reservation.getExitDate()).thenReturn(createExitDateCalendar());
        when(reservation.getKeyCode()).thenReturn(EMPTY_STRING);

        presenter.validateReservation(reservation, PARKING_LOT_INT);

        verify(view).showKeyErrorMessage();
    }

    @Test
    public void validateReservationTestErrorOverlapping() {
        model.addReservation(reservation, PARKING_LOT_INT);
        when(reservation.getEntryDate()).thenReturn(createEntryDateCalendar());
        when(reservation.getExitDate()).thenReturn(createExitDateCalendar());
        when(reservation.getKeyCode()).thenReturn(KEY_CODE);
        when(database.getParkingLots()).thenReturn(PARKING_LOT);
        when(database.getReservations(PARKING_LOT_INT)).thenReturn(getArray());

        presenter.validateReservation(reservation, PARKING_LOT_INT);

        verify(view).showOverlapMessage();
    }

    private List<Reservation> getArray() {
        ArrayList<Reservation> reservations = new ArrayList<Reservation>();
        reservations.add(reservation);
        return reservations;
    }

    @Test
    public void validateAndSaveReservationTestErrorParkingLot() {
        when(reservation.getEntryDate()).thenReturn(createEntryDateCalendar());
        when(reservation.getExitDate()).thenReturn(createExitDateCalendar());
        when(reservation.getKeyCode()).thenReturn(KEY_CODE);

        presenter.validateAndSaveReservation(reservation, EMPTY_STRING);

        verify(view).showParkingLotErrorMessage();
    }

    @Test
    public void validateAndSaveReservationTestOk() {
        when(reservation.getEntryDate()).thenReturn(createEntryDateCalendar());
        when(reservation.getExitDate()).thenReturn(createExitDateCalendar());
        when(reservation.getKeyCode()).thenReturn(KEY_CODE);
        when(database.getParkingLots()).thenReturn(PARKING_LOT);

        presenter.validateAndSaveReservation(reservation, PARKING_LOT);

        verify(view).showConfirmationMessage();
        verify(view).closeScreen();
    }

    @Test
    public void deleteOldReservations() {
        presenter.deleteOldReservations();

        verify(database).deleteOldReservations();
        verify(view).showOldReservationDeletionMessage();
    }
}
