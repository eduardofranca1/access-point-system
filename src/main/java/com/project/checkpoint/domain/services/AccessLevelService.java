package com.project.checkpoint.domain.services;

import com.project.checkpoint.domain.exceptions.ResourceNotFoundException;
import com.project.checkpoint.domain.model.AccessLevel;
import com.project.checkpoint.domain.repositories.AccessLevelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessLevelService {

    @Autowired
    private AccessLevelRepository repository;

    public AccessLevel findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Access level does not found."));
    }

    public AccessLevel create(AccessLevel accessLevel) {
        return repository.save(accessLevel);
    }

    public AccessLevel update(Long id, AccessLevel accessLevel) {

        AccessLevel accessLevelDB = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Access level does not found."));

        BeanUtils.copyProperties(accessLevel, accessLevelDB, "id");

        return repository.save(accessLevelDB);
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Access level does not found.");
        }

        repository.deleteById(id);
    }
}
