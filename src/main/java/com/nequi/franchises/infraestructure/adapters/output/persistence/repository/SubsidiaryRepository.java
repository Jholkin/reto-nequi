package com.nequi.franchises.infraestructure.adapters.output.persistence.repository;

import com.nequi.franchises.infraestructure.adapters.output.persistence.entity.SubsidiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubsidiaryRepository extends JpaRepository<SubsidiaryEntity, Long> {
}
