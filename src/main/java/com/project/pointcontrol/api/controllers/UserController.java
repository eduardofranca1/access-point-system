package com.project.pointcontrol.api.controllers;

import com.project.pointcontrol.domain.model.User;
import com.project.pointcontrol.domain.repositories.UserRepository;
import com.project.pointcontrol.domain.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "User Endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;
    private final UserService service;

    @ApiOperation(value = "Find all Users")
    @GetMapping
    public List<User> getAll() { return repository.findAll(); }

    @ApiOperation(value = "Find User by ID")
    @GetMapping("/{id}")
    public User getById(@PathVariable String id) { return service.findById(id); }

    @ApiOperation(value = "Create User")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid @RequestBody User user) { return service.create(user); }

    @ApiOperation(value = "Update User by ID")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable String id, @Valid @RequestBody User user) {
        return service.update(id, user);
    }

    @ApiOperation(value = "Delete User by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable String id) { service.delete(id); }
}
