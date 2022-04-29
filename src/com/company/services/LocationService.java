package com.company.services;

import com.company.models.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationService {
    private static List<Location> locations = new ArrayList<Location>();
    private static Integer id = 0;
    private static LocationService instance = null;

    private LocationService() {

    }
    public static LocationService getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new LocationService();
        return instance;
    }

    public Location getLocationById(Integer id) {
        for (Location location : locations) {
            if (location.getId().equals(id))
                return location;
        }
        return null;
    }
}
