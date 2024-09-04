package com.nequi.franchises.application.ports.output;

import com.nequi.franchises.domain.model.Franchise;

import java.util.Optional;

public interface FranchisePersistencePort {
    Optional<Franchise> findById(Long id);
    Franchise save(Franchise franchise);
}
