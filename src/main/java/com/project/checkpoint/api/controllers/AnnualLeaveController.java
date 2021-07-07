package com.project.checkpoint.api.controllers;

import com.project.checkpoint.domain.model.AnnualLeave;
import com.project.checkpoint.domain.repositories.AnnualLeaveRepository;
import com.project.checkpoint.domain.services.AnnualLeaveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Annual Leave Endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/annualleave")
public class AnnualLeaveController {

    private final AnnualLeaveRepository repository;
    private final AnnualLeaveService service;

    @ApiOperation(value = "Find all Annual Leave")
    @GetMapping
    public List<AnnualLeave> getAll() { return repository.findAll(); }

    @ApiOperation(value = "Find Annual Leave by ID")
    @GetMapping("/{id}")
    public AnnualLeave getById(@PathVariable Long id) { return service.findById(id); }

    @ApiOperation(value = "Create Annual Leave")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnnualLeave create(@Valid @RequestBody AnnualLeave annualLeave) { return service.create(annualLeave); }

    @ApiOperation(value = "Update Annual Leave by ID")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnnualLeave update(@PathVariable Long id, @Valid @RequestBody AnnualLeave annualLeave) {
        return service.update(id, annualLeave);
    }

    @ApiOperation(value = "Delete Annual Leave by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
