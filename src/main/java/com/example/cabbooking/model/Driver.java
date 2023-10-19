package com.example.cabbooking.model;

public class Driver extends User {
    private String vehicleModel;
    private String vehicleNumber;
    public Location currentLocation;
    private boolean available;

    public Driver(String name, String gender, int age, String vehicleModel, String vehicleNumber, Location currentLocation) {
        super(name, gender, age);
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.currentLocation = currentLocation;
        this.available = true;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
    
    public Location getCurrentLocation() {
        return currentLocation;
    }
}
