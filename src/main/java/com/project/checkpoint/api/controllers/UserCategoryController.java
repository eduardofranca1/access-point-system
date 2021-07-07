package com.project.checkpoint.api.controllers;

import com.project.checkpoint.domain.model.UserCategory;
import com.project.checkpoint.domain.repositories.UserCategoryRepository;
import com.project.checkpoint.domain.services.UserCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "User Category Endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class UserCategoryController {

    private final UserCategoryRepository repository;
    private final UserCategoryService service;

    @ApiOperation(value = "Find all Users Categories")
    @GetMapping
    public List<UserCategory> getAll() { return repository.findAll(); }

    @ApiOperation(value = "Find User Categories by ID")
    @GetMapping("/{id}")
    public UserCategory getById(@PathVariable Long id) { return service.findById(id); }

    @ApiOperation(value = "Create User Categories")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserCategory create(@Valid @RequestBody UserCategory userCategory) { return service.create(userCategory); }

    @ApiOperation(value = "Update User Category by ID")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserCategory update(@PathVariable Long id, @Valid @RequestBody UserCategory userCategory) {
        return service.update(id, userCategory);
    }

    @ApiOperation(value = "Delete User Category by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
