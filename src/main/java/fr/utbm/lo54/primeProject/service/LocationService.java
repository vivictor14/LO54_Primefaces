package fr.utbm.lo54.primeProject.service;

import fr.utbm.lo54.primeProject.entity.Location;
import fr.utbm.lo54.primeProject.repository.LocationRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("locationService")
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

}
