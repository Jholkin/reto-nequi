package com.nequi.franchises.application.ports.output;

import com.nequi.franchises.domain.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductPersistencePort {
    Mono<Product> findById(Long id);
    Flux<Product> findAll();
    Mono<Product> save(Product product);
    Mono<Void> delete(Long id);
}
