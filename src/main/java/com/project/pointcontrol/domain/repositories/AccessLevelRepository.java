package com.project.pointcontrol.domain.repositories;

import com.project.pointcontrol.domain.model.AccessLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessLevelRepository extends JpaRepository<AccessLevel, Long> {
}
