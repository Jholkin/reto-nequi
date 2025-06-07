package dev.interview.jholkin.franchises.infraestructure.adapters.output.persistence;

import dev.interview.jholkin.franchises.application.ports.output.ProductPersistencePort;
import dev.interview.jholkin.franchises.domain.model.Product;
import dev.interview.jholkin.franchises.infraestructure.adapters.output.persistence.mapper.PersistenceMapper;
import dev.interview.jholkin.franchises.infraestructure.adapters.output.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPersistencePort {
    private final ProductRepository productRepository;
    private final PersistenceMapper productMapper;

    @Override
    public Mono<Product> findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toProduct);
    }

    @Override
    public Flux<Product> findAll() {
        return productRepository.findAll()
                .map(productMapper::toProduct);
    }

    @Override
    public Mono<Product> save(Product product) {
        return productRepository.save(productMapper.toProductEntity(product))
                .map(productMapper::toProduct);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return productRepository.deleteById(id);
    }
}
