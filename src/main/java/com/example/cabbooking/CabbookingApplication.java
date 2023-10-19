package com.example.cabbooking;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cabbooking.model.Driver;
import com.example.cabbooking.model.Location;
import com.example.cabbooking.service.CabService;

@SpringBootApplication
public class CabbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabbookingApplication.class, args);
		
		// Create an instance of the cab service
        CabService cabService = new CabService();

        // Onboard users
        cabService.addUser("Abhishek", "M", 23);
        cabService.addUser("Rahul", "M", 29);
        cabService.addUser("Nandini", "F", 22);

        // Onboard drivers
        cabService.addDriver("Driver1", "M", 22, "Swift", "KA-01-12345", new Location(10, 1));
        cabService.addDriver("Driver2", "M", 29, "Swift", "KA-01-12345", new Location(11, 10));
        cabService.addDriver("Driver3", "M", 24, "Swift", "KA-01-12345", new Location(5, 3));

        // Find a ride for users
        List<Driver> abhishekRides = cabService.findRide("Abhishek", new Location(0, 0), new Location(20, 1));
        printRideOptions("Abhishek", abhishekRides);

        List<Driver> rahulRides = cabService.findRide("Rahul", new Location(10, 0), new Location(15, 3));
        printRideOptions("Rahul", rahulRides);

        List<Driver> nandiniRides = cabService.findRide("Nandini", new Location(15, 6), new Location(20, 4));
        printRideOptions("Nandini", nandiniRides);
    }

    public static void printRideOptions(String username, List<Driver> rides) {
        if (rides.isEmpty()) {
            System.out.println(username + " - No ride found");
        } else {
            System.out.println(username + " - Available rides:");
            for (Driver driver : rides) {
                System.out.println(driver.getName() + " [Available]");
            }
        }
	}

}
