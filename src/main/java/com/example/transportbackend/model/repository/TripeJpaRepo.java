package com.example.transportbackend.model.repository;

import com.example.transportbackend.model.entity.OperationEntity;
import com.example.transportbackend.model.entity.TripeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository

public interface  TripeJpaRepo extends JpaRepository<TripeEntity, UUID> {

}



