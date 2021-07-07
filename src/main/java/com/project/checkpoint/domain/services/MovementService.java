package com.project.checkpoint.domain.services;

import com.project.checkpoint.domain.exceptions.ResourceNotFoundException;
import com.project.checkpoint.domain.model.Movement;
import com.project.checkpoint.domain.repositories.MovementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementService {

    @Autowired
    private MovementRepository repository;

    public Movement findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movement does not found."));
    }

    public Movement create(Movement movement) { return repository.save(movement); }

    public Movement update(Long id, Movement movement) {

        Movement movementDB = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movement does not found."));

        BeanUtils.copyProperties(movement, movementDB, "id", "userId", "occurrence", "calendar");
        BeanUtils.copyProperties(movement.getOccurrence(), movementDB.getOccurrence(), "id");
        BeanUtils.copyProperties(movement.getCalendar(), movementDB.getCalendar(), "id");


        return repository.save(movementDB);
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Movement does not found.");
        }

        repository.deleteById(id);
    }

}
