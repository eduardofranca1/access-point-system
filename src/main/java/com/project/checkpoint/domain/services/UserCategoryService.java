package com.project.checkpoint.domain.services;

import com.project.checkpoint.domain.exceptions.ResourceNotFoundException;
import com.project.checkpoint.domain.model.UserCategory;
import com.project.checkpoint.domain.repositories.UserCategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCategoryService {

    @Autowired
    private UserCategoryRepository repository;

    public UserCategory findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category does not found."));
    }

    public UserCategory create(UserCategory userCategory) { return repository.save(userCategory); }

    public UserCategory update(Long id, UserCategory userCategory) {

        UserCategory categoryDB = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category does not found."));

        BeanUtils.copyProperties(userCategory, categoryDB, "id");

        return repository.save(categoryDB);
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Category does not found.");
        }

        repository.deleteById(id);
    }
}
