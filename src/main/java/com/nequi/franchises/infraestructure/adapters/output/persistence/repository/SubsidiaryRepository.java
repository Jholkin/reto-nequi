package com.nequi.franchises.infraestructure.adapters.output.persistence.repository;

import com.nequi.franchises.infraestructure.adapters.output.persistence.entity.SubsidiaryEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface SubsidiaryRepository extends ReactiveCrudRepository<SubsidiaryEntity, Long> {
    @Query("SELECT s.name,(SELECT p2.name FROM ProductEntity p2 WHERE p2.subsidiaryEntity = s AND p2.stock = MAX(p.stock)) as product,MAX(p.stock) as stock FROM SubsidiaryEntity s JOIN s.products p WHERE s.franchise.id=:franchiseId GROUP BY s")
    Flux<Object[]> findSubsidiariesWithProductMaxStock(@Param("franchiseId") Long franchiseId);

    @Query("FROM SubsidiaryEntity s where s.franchise.id=:franchiseId")
    Flux<SubsidiaryEntity> findByFranchiseId(@Param("franchiseId") Long franchiseId);
}
