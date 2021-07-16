package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.database.ReservationDatabase;
import com.example.parkingsystemjava.listener.ListenerDialogFragment;
import com.example.parkingsystemjava.mvp.contract.ParkingContract;
import com.example.parkingsystemjava.mvp.model.ParkingModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class ParkingPresenterTest {
    public static String PARKING_LOTS = "12";
    private ParkingContract.MainActivityPresenter presenter;
    private ParkingContract.MainActivityModel model;
    @Mock
    ListenerDialogFragment listenerDialogFragment;
    @Mock
    private ParkingContract.MainActivityView view;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        model = new ParkingModel(ReservationDatabase.getInstance());
        presenter = new ParkingPresenter(model, view);
    }

    @Test
    public void onSetParkingButtonPressedTest() {
        presenter.onSetParkingButtonPressed(listenerDialogFragment);

        verify(view).showDialogFragment(listenerDialogFragment);
    }

    @Test
    public void onReservationButtonPressedTest() {
        presenter.onReservationButtonPressed();

        verify(view).showReservationActivity();
    }

    @Test
    public void setParkingSpacesAvailableTest() {
        presenter.setParkingSpacesAvailable(PARKING_LOTS);

        assertEquals(PARKING_LOTS, ReservationDatabase.getInstance().getParkingLots());
    }

    @Test
    public void deleteOldReservationsTest() {
        presenter.deleteOldReservations();

        verify(view).showDeletedOldReservationsMessage();
    }
}
