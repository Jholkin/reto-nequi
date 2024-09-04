package com.nequi.franchises.infraestructure.adapters.output.persistence;

import com.nequi.franchises.application.ports.output.ProductPersistencePort;
import com.nequi.franchises.domain.model.Product;
import com.nequi.franchises.infraestructure.adapters.output.persistence.mapper.PersistenceMapper;
import com.nequi.franchises.infraestructure.adapters.output.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPersistencePort {
    private final ProductRepository productRepository;
    private final PersistenceMapper productMapper;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toProduct);
    }

    @Override
    public List<Product> findAll() {
        return productMapper.toProductList(productRepository.findAll());
    }

    @Override
    public Product save(Product product) {
        return productMapper.toProduct(
                productRepository.save(productMapper.toProductEntity(product))
        );
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
