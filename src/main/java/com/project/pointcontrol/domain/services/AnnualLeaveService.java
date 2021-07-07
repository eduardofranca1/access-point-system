package com.project.pointcontrol.domain.services;

import com.project.pointcontrol.domain.exceptions.ResourceNotFoundException;
import com.project.pointcontrol.domain.model.AnnualLeave;
import com.project.pointcontrol.domain.repositories.AnnualLeaveRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnualLeaveService {

    @Autowired
    private AnnualLeaveRepository repository;

    public AnnualLeave findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Annual leave does not found."));
    }

    public AnnualLeave create(AnnualLeave annualLeave) { return repository.save(annualLeave); }

    public AnnualLeave update(Long id, AnnualLeave annualLeave) {

        AnnualLeave annualLeaveDB = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Annual leave does not found."));

        BeanUtils.copyProperties(annualLeave, annualLeaveDB, "id", "annualLeaveId");

        return repository.save(annualLeaveDB);
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Annual leave does not found.");
        }

        repository.deleteById(id);
    }
}
