package com.example.parkingsystemjava.listener;

import java.io.Serializable;

public interface ListenerDialogFragment extends Serializable {
    void listenFreeSpaces(String freeSpaces);
}
