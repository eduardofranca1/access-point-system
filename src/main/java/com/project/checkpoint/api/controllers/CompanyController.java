package com.project.checkpoint.api.controllers;

import com.project.checkpoint.domain.model.Company;
import com.project.checkpoint.domain.repositories.CompanyRepository;
import com.project.checkpoint.domain.services.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Company Endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyRepository repository;
    private final CompanyService service;

    @ApiOperation(value = "Find all Companies")
    @GetMapping
    public List<Company> getAll() { return repository.findAll(); }

    @ApiOperation(value = "Find Company by ID")
    @GetMapping("/{id}")
    public Company getById(@PathVariable Long id) { return service.findById(id); }

    @ApiOperation(value = "Create Company")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(@Valid @RequestBody Company company) { return service.create(company); }

    @ApiOperation(value = "Update Company by ID")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company update(@PathVariable Long id, @Valid @RequestBody Company company) { return service.update(id, company); }

    @ApiOperation(value = "Delete Company by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }

}
