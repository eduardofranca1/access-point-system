package com.project.checkpoint.domain.repositories;

import com.project.checkpoint.domain.model.DateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTypeRepository extends JpaRepository<DateType, Long> { }
