package com.project.pointcontrol.domain.services;

import com.project.pointcontrol.domain.exceptions.ResourceNotFoundException;
import com.project.pointcontrol.domain.model.WorkJourney;
import com.project.pointcontrol.domain.repositories.WorkJourneyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkJourneyService {

    @Autowired
    private WorkJourneyRepository repository;

    public WorkJourney findById (Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Work journey does not found."));
    }

    public WorkJourney create (WorkJourney workJourney) {
        return repository.save(workJourney);
    }

    public WorkJourney update (Long id, WorkJourney workJourney) {

        WorkJourney journeyDB = repository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Work journey does not found.");
        });

        BeanUtils.copyProperties(workJourney, journeyDB, "id");

        return repository.save(journeyDB);

    }

    public void deleteById(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Work journey does not found.");
        }

        repository.deleteById(id);
    }
}
