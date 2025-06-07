package dev.interview.jholkin.franchises.application.ports.input;

import dev.interview.jholkin.franchises.domain.model.Franchise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranchiseServicePort {
    Mono<Franchise> save(Franchise franchise);
    Mono<Franchise> findById(Long id);
    Mono<Franchise> update(Long id, Franchise franchise);
    Flux<Franchise> findAll();
}
