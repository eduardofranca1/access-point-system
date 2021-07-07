package com.project.pointcontrol.domain.repositories;

import com.project.pointcontrol.domain.model.AnnualLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnualLeaveRepository extends JpaRepository<AnnualLeave, Long> {
}
