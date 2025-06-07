package dev.interview.jholkin.franchises.application.ports.output;

import dev.interview.jholkin.franchises.domain.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductPersistencePort {
    Mono<Product> findById(Long id);
    Flux<Product> findAll();
    Mono<Product> save(Product product);
    Mono<Void> delete(Long id);
}
