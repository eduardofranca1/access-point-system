package com.project.checkpoint.domain.services;

import com.project.checkpoint.domain.exceptions.ResourceNotFoundException;
import com.project.checkpoint.domain.model.AccessLevel;
import com.project.checkpoint.domain.model.Calendar;
import com.project.checkpoint.domain.repositories.CalendarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository repository;


    public Calendar findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Calendar does not found."));
    }

    public Calendar create(Calendar calendar) {
        return repository.save(calendar);
    }

    public Calendar update(Long id, Calendar calendar) {

        Calendar calendarDB = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Calendar does not found."));

        BeanUtils.copyProperties(calendar, calendarDB, "id", "dateType");
        BeanUtils.copyProperties(calendar.getDateType(), calendarDB.getDateType(), "id");

        return repository.save(calendarDB);
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Calendar does not found.");
        }

        repository.deleteById(id);
    }
}
