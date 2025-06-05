package com.nequi.franchises.application.ports.output;

import com.nequi.franchises.domain.model.Franchise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranchisePersistencePort {
    Mono<Franchise> findById(Long id);
    Mono<Franchise> save(Franchise franchise);
    Flux<Franchise> findAll();
}
