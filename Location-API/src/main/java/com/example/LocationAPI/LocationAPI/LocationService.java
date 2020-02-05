package com.example.LocationAPI.LocationAPI;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LocationService {

    private static List<Location> locations = new ArrayList();
    //stimmt long???
    private static long idCounter = 0;




    static {
        locations.add(new Location(++idCounter, "in28minutes", "test2.jpg", "Milano", "its a beautilful City", new Date()));
        locations.add(new Location(++idCounter, "in28minutes", "Bern.jpeg","Milano","its a beautilful City",new Date()));
        locations.add(new Location(++idCounter, "in28minutes", "Basler.jpg","Milano","its a beautilful City",new Date()));
        locations.add(new Location(++idCounter, "in28minutes", "Basler.jpg","Milano","its a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful Cityits a beautilful City",new Date()));
    }
    public List<Location> findAll(){
        return locations;
    }

    public Location deleteById(long id){
        Location location = findById(id);
        if (location == null){
            return null;
        }
        if (locations.remove(location)){
            return location;
        }
        return null;
    }

    public Location findById(long id){
        for(Location location:locations){
            if (location.getId() == id){
                return location;
            }
        }
        return null;
    }
    public Location save(Location location){
        if(location.getId()==-1){
            location.setId(++idCounter);
            locations.add(location);
        }

        else {
            deleteById(location.getId());
            locations.add(location);
        }
        return location;
    }

}
