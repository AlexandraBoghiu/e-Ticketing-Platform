package com.company.services;

import com.company.models.Location;

import java.util.ArrayList;

public class LocationService {
    static private ArrayList<Location> locations = new ArrayList<Location>();
    static private Integer id = 0;
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
