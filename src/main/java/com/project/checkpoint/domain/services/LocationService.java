package com.project.checkpoint.domain.services;

import com.project.checkpoint.domain.exceptions.ResourceNotFoundException;
import com.project.checkpoint.domain.model.Location;
import com.project.checkpoint.domain.repositories.LocationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repository;

    public Location findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location does not found."));
    }

    public Location create(Location location) {
        return repository.save(location);
    }

    public Location update(Long id, Location location) {

        Location locationDB = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location does not found."));

        BeanUtils.copyProperties(location, locationDB, "id", "accessLevel");
        BeanUtils.copyProperties(location.getAccessLevel(), locationDB.getAccessLevel(), "id");

        return repository.save(locationDB);
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Access level does not found.");
        }

        repository.deleteById(id);
    }
}
