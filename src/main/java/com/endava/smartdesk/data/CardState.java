package com.endava.smartdesk.data;

public enum CardState {
    AVAILABLE(0),
    ASSIGNED(1),
    LOST(2),
    INACTIVE_LOST(3),
    INACTIVE_FOUND(4);

    private final int state;

    CardState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
