package com.example.cabbooking.service;

import java.util.ArrayList;
import java.util.List;

import com.example.cabbooking.model.Driver;
import com.example.cabbooking.model.Location;
import com.example.cabbooking.model.User;
import com.example.cabbooking.util.DistanceCalculator;

public class CabService {
    private List<User> users;
    private List<Driver> drivers;

    public CabService() {
        users = new ArrayList<>();
        drivers = new ArrayList<>();
    }
    
    public List<User> getUsers() {
        return users;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void addUser(String name, String gender, int age) {
        users.add(new User(name, gender, age));
    }

    public void addDriver(String name, String gender, int age, String vehicleModel, String vehicleNumber, Location currentLocation) {
        drivers.add(new Driver(name, gender, age, vehicleModel, vehicleNumber, currentLocation));
    }

    public List<Driver> findRide(String username, Location source, Location destination) {
        List<Driver> availableRides = new ArrayList<>();
        for (Driver driver : drivers) {
            if (driver.isAvailable() && DistanceCalculator.calculateDistance(driver.currentLocation, source) <= 5) {
                availableRides.add(driver);
            }
        }
        return availableRides;
    }
}
