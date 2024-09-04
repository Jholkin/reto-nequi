package com.nequi.franchises.infraestructure.adapters.output.persistence.repository;

import com.nequi.franchises.infraestructure.adapters.output.persistence.entity.FranchiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<FranchiseEntity, Long> {
}
