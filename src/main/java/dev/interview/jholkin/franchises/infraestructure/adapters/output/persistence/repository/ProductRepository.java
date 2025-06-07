package dev.interview.jholkin.franchises.infraestructure.adapters.output.persistence.repository;

import dev.interview.jholkin.franchises.infraestructure.adapters.output.persistence.entity.ProductEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, Long> {
}
