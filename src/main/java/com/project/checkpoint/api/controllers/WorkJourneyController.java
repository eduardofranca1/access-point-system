package com.project.checkpoint.api.controllers;

import com.project.checkpoint.domain.model.WorkJourney;
import com.project.checkpoint.domain.repositories.WorkJourneyRepository;
import com.project.checkpoint.domain.services.WorkJourneyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Work Journey Endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/journey")
public class WorkJourneyController {

    private final WorkJourneyService service;
    private final WorkJourneyRepository repository;

    @ApiOperation(value = "Find all Works Journeys")
    @GetMapping
    public List<WorkJourney> getAll() {
        return repository.findAll();
    }

    @ApiOperation(value = "Find Work Journey by ID")
    @GetMapping("/{id}")
    public WorkJourney getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @ApiOperation(value = "Create Work Journey")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkJourney create(@Valid @RequestBody WorkJourney workJourney) {
        return service.create(workJourney);
    }

    @ApiOperation(value = "Update Work Journey by ID")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WorkJourney update(@PathVariable Long id, @Valid @RequestBody WorkJourney workJourney) {
        return service.update(id, workJourney);
    }

    @ApiOperation(value = "Delete Work Journey by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
