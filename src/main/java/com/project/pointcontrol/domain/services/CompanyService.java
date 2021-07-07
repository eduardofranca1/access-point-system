package com.project.pointcontrol.domain.services;

import com.project.pointcontrol.domain.exceptions.BusinessException;
import com.project.pointcontrol.domain.exceptions.ResourceNotFoundException;
import com.project.pointcontrol.domain.model.Company;
import com.project.pointcontrol.domain.repositories.CompanyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public Company findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company does not found."));
    }

    public Company create(Company company) {

        boolean existingCpnj = repository.findOptionalByCnpjNumber(company.getCnpjNumber())
                .stream()
                .anyMatch(existingCompanyCnpj -> !existingCompanyCnpj.equals(company));

        if(existingCpnj){
            throw new BusinessException("Already have a company with this cnpj.");
        }

        return repository.save(company);
    }

    public Company update(Long id, Company company) {

        Company companyDB = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company does not found."));

        BeanUtils.copyProperties(company, companyDB, "id", "createdAt");

        return repository.save(companyDB);
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Company does not found.");
        }

        repository.deleteById(id);
    }


}
