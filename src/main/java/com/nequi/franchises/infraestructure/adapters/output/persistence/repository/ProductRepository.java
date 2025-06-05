package com.nequi.franchises.infraestructure.adapters.output.persistence.repository;

import com.nequi.franchises.infraestructure.adapters.output.persistence.entity.ProductEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, Long> {
}
