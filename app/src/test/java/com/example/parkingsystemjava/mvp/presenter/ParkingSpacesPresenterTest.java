package com.example.parkingsystemjava.mvp.presenter;

import com.example.parkingsystemjava.listener.ListenerDialogFragment;
import com.example.parkingsystemjava.mvp.contract.ParkingSpacesContract;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class ParkingSpacesPresenterTest {

    private static final String FREE_SPACES = "12";
    private static final String EMPTY_STRING = "";
    private ParkingSpacesContract.ParkingSpacesDialogFragmentPresenter presenter;
    @Mock
    ParkingSpacesContract.ParkingSpacesDialogFragmentView view;
    @Mock
    ListenerDialogFragment listenerDialogFragment;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        presenter = new ParkingSpacesPresenter(view);
    }

    @Test
    public void onButtonDialogFragmentSpacesSettingConfirmationPressedTestOk() {
        presenter.onButtonDialogFragmentSpacesSettingConfirmationPressed(FREE_SPACES, listenerDialogFragment);
        verify(view).showParkingLotsAvailable(FREE_SPACES, listenerDialogFragment);
    }

    @Test
    public void onButtonDialogFragmentSpacesSettingConfirmationPressedTestInvalid() {
        presenter.onButtonDialogFragmentSpacesSettingConfirmationPressed(EMPTY_STRING, listenerDialogFragment);
        verify(view).showInvalidValue();
    }
}
