package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.listener.ListenerDateTime;
import com.example.parkingsystemjava.mvp.contract.ParkingDatePickerContract;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class ParkingDatePickerPresenterTest {
    ParkingDatePickerContract.ParkingDatePickerPresenter presenter;
    @Mock
    ListenerDateTime listenerDateTime;
    @Mock
    ParkingDatePickerContract.ParkingDatePickerView view;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        presenter = new ParkingDatePickerPresenter(view, true);
    }

    @Test
    public void onButtonDialogFragmentDatePickerConfirmationPressedTestTrue() {
        presenter.onButtonDialogFragmentDatePickerConfirmationPressed(listenerDateTime);

        verify(view).showEntryReservationDate(listenerDateTime);
    }

    @Test
    public void onButtonDialogFragmentDatePickerConfirmationPressedTestFalse() {
        ParkingDatePickerContract.ParkingDatePickerPresenter presenterFalse = new ParkingDatePickerPresenter(view, false);
        presenterFalse.onButtonDialogFragmentDatePickerConfirmationPressed(listenerDateTime);

        verify(view).showExitReservationDate(listenerDateTime);
    }

    @Test
    public void closeDateDialogTest() {
        presenter.closeDateDialog();

        verify(view).closeDateDialog();
    }
}
