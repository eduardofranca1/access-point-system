package com.project.pointcontrol.domain.repositories;

import com.project.pointcontrol.domain.model.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> { }
