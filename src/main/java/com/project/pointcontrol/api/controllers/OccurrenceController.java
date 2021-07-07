package com.project.pointcontrol.api.controllers;

import com.project.pointcontrol.domain.model.Occurrence;
import com.project.pointcontrol.domain.repositories.OccurrenceRepository;
import com.project.pointcontrol.domain.services.OccurrenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Occurrence Endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/occurrence")
public class OccurrenceController {

    private final OccurrenceRepository repository;
    private final OccurrenceService service;

    @ApiOperation(value = "Find all Occurrence")
    @GetMapping
    public List<Occurrence> getAll() { return repository.findAll(); }

    @ApiOperation(value = "Find Occurrence by ID")
    @GetMapping("/{id}")
    public Occurrence getById(@PathVariable Long id) { return service.findById(id); }

    @ApiOperation(value = "Create Occurrence")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Occurrence create(@Valid @RequestBody Occurrence occurrence) { return service.create(occurrence); }

    @ApiOperation(value = "Update Occurrence by ID")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Occurrence update(@PathVariable Long id, @Valid @RequestBody Occurrence occurrence) {
        return service.update(id, occurrence);
    }

    @ApiOperation(value = "Delete Occurrence by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}

