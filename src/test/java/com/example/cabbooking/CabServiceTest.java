package com.example.cabbooking;

import com.example.cabbooking.model.Location;
import com.example.cabbooking.model.Driver;
import com.example.cabbooking.service.CabService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CabServiceTest {

    private CabService cabService;

    @Before
    public void setUp() {
        cabService = new CabService();
    }

    @Test
    public void testFindRideNoAvailableRides() {
        // Add a driver who is far away
        cabService.addDriver("Driver1", "M", 22, "Swift", "KA-01-12345", new Location(10, 10));
        Location source = new Location(0, 0);
        Location destination = new Location(20, 1);

        List<Driver> availableRides = cabService.findRide("User1", source, destination);

        assertEquals(0, availableRides.size());
    }

    @Test
    public void testFindRideAvailableRides() {
        // Add a driver who is nearby and available
        cabService.addDriver("Driver2", "M", 29, "Swift", "KA-01-12345", new Location(10, 1));
        Location source = new Location(0, 0);
        Location destination = new Location(20, 1);

        List<Driver> availableRides = cabService.findRide("User2", source, destination);

        assertEquals(1, availableRides.size());
        assertEquals("Driver2", availableRides.get(0).getName());
    }

    @Test
    public void testAddUser() {
        cabService.addUser("User3", "F", 25);

        // Add assertion to check if the user was added successfully
        assertEquals(1, cabService.getUsers().size());
    }

    @Test
    public void testAddDriver() {
        cabService.addDriver("Driver3", "M", 30, "SUV", "KA-02-67890", new Location(15, 5));

        // Add assertion to check if the driver was added successfully
        assertEquals(1, cabService.getDrivers().size());
    }

    @Test
    public void testDriverAvailability() {
        cabService.addDriver("Driver4", "M", 28, "Sedan", "KA-03-54321", new Location(3, 3));
        Location source = new Location(0, 0);
        Location destination = new Location(10, 10);

        List<Driver> availableRides = cabService.findRide("User4", source, destination);

        // Assert that Driver4 is not available and should not be in the list
        for (Driver driver : availableRides) {
            assertNotEquals("Driver4", driver.getName());
        }
    }
    
    // Add more test cases as needed to cover different scenarios
}
