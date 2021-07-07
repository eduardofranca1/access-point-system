package com.project.pointcontrol.domain.repositories;

import com.project.pointcontrol.domain.model.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCategoryRepository extends JpaRepository<UserCategory, Long> { }
