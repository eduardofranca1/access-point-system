package com.project.pointcontrol.domain.repositories;

import com.project.pointcontrol.domain.model.WorkJourney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkJourneyRepository extends JpaRepository<WorkJourney, Long> {
}
