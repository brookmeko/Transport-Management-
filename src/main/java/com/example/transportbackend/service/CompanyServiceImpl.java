package com.example.transportbackend.service;

import com.example.transportbackend.exception.ResourceNotFoundException;
import com.example.transportbackend.model.dto.AddressDTO;
import com.example.transportbackend.model.dto.CompanyDTO;
import com.example.transportbackend.model.entity.AddressEntity;
import com.example.transportbackend.model.entity.CompanyEntity;
import com.example.transportbackend.model.repository.AddressJpaRepo;
import com.example.transportbackend.model.repository.CompanyJpaRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CompanyJpaRepo repository;

    @Autowired
    private AddressJpaRepo addressJpaRepo;


    @Override
    public List<CompanyDTO> getAllCompany() {
        List<CompanyDTO> companyDTO = repository.findAll().stream()
                .map(company -> modelMapper.map(company, CompanyDTO.class)).collect(Collectors.toList());
        return companyDTO;
    }

    @Override
    public CompanyDTO getCompanyById(UUID id) {
        try{
            Optional<CompanyEntity> company = repository.findById(id);
            CompanyDTO companyDTO = modelMapper.map(company, CompanyDTO.class);

            return companyDTO;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean createCompany(CompanyDTO companyDTO) {
        try{
            CompanyEntity company = modelMapper.map(companyDTO, CompanyEntity.class);
            AddressEntity addressEntity=addressJpaRepo.getReferenceById(companyDTO.getAddressId());
            company.setAddress(addressEntity);
            repository.save(company);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCompany(CompanyDTO companyDTO) {
        try {
            CompanyEntity company = modelMapper.map(companyDTO, CompanyEntity.class);
            AddressEntity addressEntity = addressJpaRepo.getReferenceById(companyDTO.getAddressId());
            company.setAddress(addressEntity);
            repository.save(company);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCompany(UUID id) {
        try {
            CompanyEntity company = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("company info not found for this id ::" + id));
            repository.delete(company);
            return true;
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
