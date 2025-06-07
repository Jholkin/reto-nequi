package dev.interview.jholkin.franchises.application.ports.input;

import dev.interview.jholkin.franchises.domain.model.ProductTop;
import dev.interview.jholkin.franchises.domain.model.Subsidiary;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubsidiaryServicePort {
    Mono<Subsidiary> findById(long id);
    Flux<Subsidiary> findAll(long franchiseId);
    Mono<Subsidiary> save(Subsidiary subsidiary);
    Mono<Subsidiary> update(long id, Subsidiary subsidiary);
    Flux<ProductTop> findSubsidiariesWithProductMaxStock(Long franchiseId);
}
