package com.project.checkpoint.domain.services;

import com.project.checkpoint.domain.exceptions.ResourceNotFoundException;
import com.project.checkpoint.domain.model.User;
import com.project.checkpoint.domain.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User does not found."));
    }

    public User create(User user) { return repository.save(user); }

    public User update(String id, User user) {

        User userDB = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User does not found."));

        BeanUtils.copyProperties(user, userDB, "id", "userCategory", "company", "accessLevel", "workJourney", "createdAt", "updatedAt");
        BeanUtils.copyProperties(user.getUserCategory(), userDB.getUserCategory(), "id");
        BeanUtils.copyProperties(user.getCompany(), userDB.getCompany(), "id");
        BeanUtils.copyProperties(user.getAccessLevel(), userDB.getAccessLevel(), "id");
        BeanUtils.copyProperties(user.getWorkJourney(), userDB.getWorkJourney(), "id");

        return repository.save(userDB);

    }

    public void delete(String id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("User does not found.");
        }

        repository.deleteById(id);
    }
}
