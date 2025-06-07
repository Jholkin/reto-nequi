package dev.interview.jholkin.franchises.application.ports.input;

import dev.interview.jholkin.franchises.domain.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductServicePort {
    Mono<Product> findProduct(Long id);
    Flux<Product> findAllProducts();
    Mono<Product> createProduct(Product product);
    Mono<Product> updateProduct(Long id, Product product);
    Mono<Void> deleteProduct(Long id);
}
