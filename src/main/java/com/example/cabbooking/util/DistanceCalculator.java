package com.example.cabbooking.util;

import com.example.cabbooking.model.Location;

public class DistanceCalculator {

    public static double calculateDistance(Location location1, Location location2) {
        // Implement your distance calculation logic here (e.g., Haversine formula)
        // This is a simplified example and may not be accurate for large distances
        double lat1 = location1.getLatitude();
        double lon1 = location1.getLongitude();
        double lat2 = location2.getLatitude();
        double lon2 = location2.getLongitude();
        return Math.sqrt(Math.pow(lat2 - lat1, 2) + Math.pow(lon2 - lon1, 2));
    }
}
