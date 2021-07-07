package com.project.pointcontrol.api.controllers;

import com.project.pointcontrol.domain.model.DateType;
import com.project.pointcontrol.domain.repositories.DateTypeRepository;
import com.project.pointcontrol.domain.services.DateTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Date Type Endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/datetype")
public class DateTypeController {

    private final DateTypeRepository repository;
    private final DateTypeService service;

    @ApiOperation(value = "Find all Dates Types")
    @GetMapping
    public List<DateType> getAll() { return repository.findAll(); }

    @ApiOperation(value = "Find Date Type by ID")
    @GetMapping("/{id}")
    public DateType getById(@PathVariable Long id) { return service.findById(id); }

    @ApiOperation(value = "Create Date Type")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DateType create(@Valid @RequestBody DateType dateType) { return service.create(dateType); }

    @ApiOperation(value = "Update Date Type by ID")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DateType update(@PathVariable Long id, @Valid @RequestBody DateType dateType) {
        return service.update(id, dateType);
    }

    @ApiOperation(value = "Delete Date Type by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}

