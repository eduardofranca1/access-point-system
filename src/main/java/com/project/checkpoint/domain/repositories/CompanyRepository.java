package com.project.checkpoint.domain.repositories;

import com.project.checkpoint.domain.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findOptionalByCnpjNumber(String cnpjNumber);

}
