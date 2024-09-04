package com.nequi.franchises.application.ports.output;

import com.nequi.franchises.domain.model.ProductTop;
import com.nequi.franchises.domain.model.Subsidiary;

import java.util.List;
import java.util.Optional;

public interface SubsidiaryPersistencePort {
    Optional<Subsidiary> findById(long id);
    Subsidiary save(Subsidiary subsidiary);
    List<Subsidiary> findAll(long franchiseId);
    List<ProductTop> findSubsidiariesWithProductMaxStock(Long franchiseId);
}
