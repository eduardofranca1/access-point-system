package com.project.checkpoint.domain.services;

import com.project.checkpoint.domain.exceptions.ResourceNotFoundException;
import com.project.checkpoint.domain.model.Occurrence;
import com.project.checkpoint.domain.repositories.OccurrenceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccurrenceService {

    @Autowired
    private OccurrenceRepository repository;

    public Occurrence findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Occurrence does not found."));
    }

    public Occurrence create(Occurrence occurrence) { return repository.save(occurrence); }

    public Occurrence update(Long id, Occurrence occurrence) {

        Occurrence occurrenceDB = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Occurrence does not found."));

        BeanUtils.copyProperties(occurrence, occurrenceDB, "id");

        return repository.save(occurrenceDB);
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Occurrence does not found.");
        }

        repository.deleteById(id);
    }
}

