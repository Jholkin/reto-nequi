package com.nequi.franchises.application.ports.output;

import com.nequi.franchises.domain.model.ProductTop;
import com.nequi.franchises.domain.model.Subsidiary;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubsidiaryPersistencePort {
    Mono<Subsidiary> findById(long id);
    Mono<Subsidiary> save(Subsidiary subsidiary);
    Flux<Subsidiary> findAll(long franchiseId);
    Flux<ProductTop> findSubsidiariesWithProductMaxStock(Long franchiseId);
}
