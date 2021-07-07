package com.project.pointcontrol.domain.services;

import com.project.pointcontrol.domain.exceptions.ResourceNotFoundException;
import com.project.pointcontrol.domain.model.DateType;
import com.project.pointcontrol.domain.repositories.DateTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateTypeService {

    @Autowired
    private DateTypeRepository repository;

    public DateType findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Date type does not found."));
    }

    public DateType create(DateType dateType) { return repository.save(dateType); }

    public DateType update(Long id, DateType dateType) {

        DateType dateTypeDB = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Date type does not found."));

        BeanUtils.copyProperties(dateType, dateTypeDB, "id");

        return repository.save(dateTypeDB);
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Date type does not found.");
        }

        repository.deleteById(id);
    }
}

