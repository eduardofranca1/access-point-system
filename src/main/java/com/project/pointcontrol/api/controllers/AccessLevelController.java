package com.project.pointcontrol.api.controllers;

import com.project.pointcontrol.domain.model.AccessLevel;
import com.project.pointcontrol.domain.repositories.AccessLevelRepository;
import com.project.pointcontrol.domain.services.AccessLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Access Level Endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/accesslevel")
public class AccessLevelController {

    private final AccessLevelRepository repository;
    private final AccessLevelService service;

    @ApiOperation(value = "Find all Access Levels")
    @GetMapping
    public List<AccessLevel> getAll() { return repository.findAll(); }

    @ApiOperation(value = "Find Access Level by ID")
    @GetMapping("/{id}")
    public AccessLevel getById(@PathVariable Long id) { return service.findById(id); }

    @ApiOperation(value = "Create Access Level")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccessLevel create(@Valid @RequestBody AccessLevel accessLevel) { return service.create(accessLevel); }

    @ApiOperation(value = "Update Access Level by ID")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccessLevel update(@PathVariable Long id, @Valid @RequestBody AccessLevel accessLevel) {
        return service.update(id, accessLevel);
    }

    @ApiOperation(value = "Delete Access Level by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
