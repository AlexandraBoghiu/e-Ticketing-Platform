package services;


import java.util.ArrayList;
import java.util.Arrays;
import locations.Locations;


public class LocationService {
    static ArrayList<Locations> locations = new ArrayList<Locations>();
    static Integer id = 0;

    public LocationService() {

    }

    public Locations getLocationById(Integer id) {
        for (Locations location : locations) {
            if (location.getId().equals(id))
                return location;
        }
        return null;
    }
}
