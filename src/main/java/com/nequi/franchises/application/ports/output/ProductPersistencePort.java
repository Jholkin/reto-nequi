package com.nequi.franchises.application.ports.output;

import com.nequi.franchises.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductPersistencePort {
    Optional<Product> findById(Long id);
    List<Product> findAll();
    Product save(Product product);
    void delete(Long id);
}
