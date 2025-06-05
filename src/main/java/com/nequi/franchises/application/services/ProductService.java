package com.nequi.franchises.application.services;

import com.nequi.franchises.application.ports.input.ProductServicePort;
import com.nequi.franchises.application.ports.output.ProductPersistencePort;
import com.nequi.franchises.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServicePort {
    private final ProductPersistencePort productPersistencePort;

    @Override
    public Mono<Product> findProduct(Long id) {
        return productPersistencePort.findById(id);
    }

    @Override
    public Flux<Product> findAllProducts() {
        return productPersistencePort.findAll();
    }

    @Override
    public Mono<Product> createProduct(Product product) {
        return productPersistencePort.save(product);
    }

    @Override
    public Mono<Product> updateProduct(Long id, Product product) {
        return productPersistencePort.findById(id)
                .flatMap(savedProduct -> {
                    if (!product.getName().isEmpty()) savedProduct.setName(product.getName());
                    if (product.getStock() != 0) savedProduct.setStock(product.getStock());
                    return productPersistencePort.save(savedProduct);
                });
    }

    @Override
    public Mono<Void> deleteProduct(Long id) {
        return productPersistencePort.findById(id)
                .map(Product::getId)
                .flatMap(productPersistencePort::delete);
    }
}
