package dev.interview.jholkin.franchises.application.ports.output;

import dev.interview.jholkin.franchises.domain.model.Franchise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranchisePersistencePort {
    Mono<Franchise> findById(Long id);
    Mono<Franchise> save(Franchise franchise);
    Flux<Franchise> findAll();
}
