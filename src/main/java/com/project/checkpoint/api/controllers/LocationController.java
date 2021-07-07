package com.project.checkpoint.api.controllers;

import com.project.checkpoint.domain.model.Location;
import com.project.checkpoint.domain.repositories.LocationRepository;
import com.project.checkpoint.domain.services.LocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Location Endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationRepository repository;
    private final LocationService service;

    @ApiOperation(value = "Find all Locations")
    @GetMapping
    public List<Location> getAll() { return repository.findAll(); }

    @ApiOperation(value = "Find Location by ID")
    @GetMapping("/{id}")
    public Location getById(@PathVariable Long id) { return service.findById(id); }

    @ApiOperation(value = "Create Location")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location create(@Valid @RequestBody Location location) { return service.create(location); }

    @ApiOperation(value = "Update Location by ID")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Location update(@PathVariable Long id, @Valid @RequestBody Location location) {
        return service.update(id, location);
    }

    @ApiOperation(value = "Delete Location by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
