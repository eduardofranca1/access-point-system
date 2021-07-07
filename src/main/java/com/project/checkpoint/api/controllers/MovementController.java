package com.project.checkpoint.api.controllers;

import com.project.checkpoint.domain.model.Movement;
import com.project.checkpoint.domain.repositories.MovementRepository;
import com.project.checkpoint.domain.services.MovementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Movement Endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/movement")
public class MovementController {

    private final MovementRepository repository;
    private final MovementService service;

    @ApiOperation(value = "Find all Movements")
    @GetMapping
    public List<Movement> getAll() { return repository.findAll(); }

    @ApiOperation(value = "Find Movements by ID")
    @GetMapping("/{id}")
    public Movement getById(@PathVariable Long id) { return service.findById(id); }

    @ApiOperation(value = "Create Movement")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movement create(@Valid @RequestBody Movement movement) { return service.create(movement); }

    @ApiOperation(value = "Update Movements by ID")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movement update(@PathVariable Long id, @Valid @RequestBody Movement movement) {
        return service.update(id, movement);
    }

    @ApiOperation(value = "Delete Movements by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }

}
