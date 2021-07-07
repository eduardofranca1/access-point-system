package com.project.checkpoint.api.controllers;

import com.project.checkpoint.domain.model.AnnualLeave;
import com.project.checkpoint.domain.model.Calendar;
import com.project.checkpoint.domain.repositories.CalendarRepository;
import com.project.checkpoint.domain.services.CalendarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Calendar Endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/calendar")
public class CalendarController {

    private final CalendarRepository repository;
    private final CalendarService service;

    @ApiOperation(value = "Find all Calendars")
    @GetMapping
    public List<Calendar> getAll() { return repository.findAll(); }

    @ApiOperation(value = "Find Calendar by ID")
    @GetMapping("/{id}")
    public Calendar getById(@PathVariable Long id) { return service.findById(id); }

    @ApiOperation(value = "Create Calendar")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Calendar create(@Valid @RequestBody Calendar calendar) { return service.create(calendar); }

    @ApiOperation(value = "Update Calendar by ID")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Calendar update(@PathVariable Long id, @Valid @RequestBody Calendar calendar) {
        return service.update(id, calendar);
    }

    @ApiOperation(value = "Delete Calendar by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
