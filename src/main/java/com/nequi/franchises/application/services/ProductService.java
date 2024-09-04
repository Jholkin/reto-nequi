package com.nequi.franchises.application.services;

import com.nequi.franchises.application.ports.input.ProductServicePort;
import com.nequi.franchises.application.ports.output.ProductPersistencePort;
import com.nequi.franchises.domain.exception.ProductNotFoundException;
import com.nequi.franchises.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServicePort {
    private final ProductPersistencePort productPersistencePort;

    @Override
    public Product findProduct(Long id) {
        return productPersistencePort.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<Product> findAllProducts() {
        return productPersistencePort.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productPersistencePort.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return productPersistencePort.findById(id)
                .map(savedProduct -> {
                    savedProduct.setName(product.getName());
                    savedProduct.setStock(product.getStock());
                    return productPersistencePort.save(savedProduct);
                })
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void deleteProduct(Long id) {
        if(productPersistencePort.findById(id).isEmpty()) {
            throw new ProductNotFoundException();
        }
        productPersistencePort.delete(id);
    }
}
