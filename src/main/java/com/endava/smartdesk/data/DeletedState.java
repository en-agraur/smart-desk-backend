package com.endava.smartdesk.data;

public enum DeletedState {

    AVAILABLE(0),
    DELETED(1);

    private final int state;

    DeletedState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
