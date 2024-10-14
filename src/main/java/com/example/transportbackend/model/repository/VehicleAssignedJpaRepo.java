package com.example.transportbackend.model.repository;

import com.example.transportbackend.model.entity.VehicleAssignedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository

public interface VehicleAssignedJpaRepo extends JpaRepository<VehicleAssignedEntity, UUID> {
}
