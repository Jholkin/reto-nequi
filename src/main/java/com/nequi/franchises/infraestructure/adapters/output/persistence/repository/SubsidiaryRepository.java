package com.nequi.franchises.infraestructure.adapters.output.persistence.repository;

import com.nequi.franchises.infraestructure.adapters.output.persistence.entity.SubsidiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubsidiaryRepository extends JpaRepository<SubsidiaryEntity, Long> {
    @Query("SELECT s.name,(SELECT p2.name FROM ProductEntity p2 WHERE p2.subsidiaryEntity = s AND p2.stock = MAX(p.stock)) as product,MAX(p.stock) as stock FROM SubsidiaryEntity s JOIN s.products p WHERE s.franchise.id=:franchiseId GROUP BY s")
    List<Object[]> findSubsidiariesWithProductMaxStock(@Param("franchiseId") Long franchiseId);
}
