package com.project.checkpoint.domain.repositories;

import com.project.checkpoint.domain.model.WorkJourney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkJourneyRepository extends JpaRepository<WorkJourney, Long> {
}
