package dev.interview.jholkin.franchises.application.ports.output;

import dev.interview.jholkin.franchises.domain.model.ProductTop;
import dev.interview.jholkin.franchises.domain.model.Subsidiary;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubsidiaryPersistencePort {
    Mono<Subsidiary> findById(long id);
    Mono<Subsidiary> save(Subsidiary subsidiary);
    Flux<Subsidiary> findAll(long franchiseId);
    Flux<ProductTop> findSubsidiariesWithProductMaxStock(Long franchiseId);
}
