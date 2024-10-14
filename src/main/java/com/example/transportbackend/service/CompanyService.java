package com.example.transportbackend.service;

import com.example.transportbackend.model.dto.CompanyDTO;

import java.util.List;
import java.util.UUID;

public interface CompanyService {

    List<CompanyDTO> getAllCompany();

    CompanyDTO getCompanyById(UUID id);

    boolean createCompany(CompanyDTO companyDTO);

    boolean updateCompany(CompanyDTO companyDTO);

    boolean deleteCompany(UUID id);


}
