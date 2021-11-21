package com.endava.smartdesk.data;

public class Office {

    private final String city;
    private final String location;

    public Office(String city, String location) {
        this.city = city;
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public String getLocation() {
        return location;
    }
}
