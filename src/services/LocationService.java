package services;


import java.util.ArrayList;
import java.util.Arrays;
import locations.Locations;


public class LocationService {
    ArrayList<Locations> locations = new ArrayList<Locations>();
    static Integer id = 0;

    public LocationService() {

    }

    public void createLocation(String parameters) {
        id++;
        String[] parametersArray = parameters.split(", ");
        System.out.println(Arrays.toString(parametersArray));
        Locations location = new Locations(id, parametersArray[0], parametersArray[1], parametersArray[2]);
        System.out.println(location);
        locations.add(location);
    }
    public Locations getLocationById(Integer id) {
        for (Locations location : locations) {
            if (location.getId().equals(id))
                return location;
        }
        return null;
    }
}
