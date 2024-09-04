package com.nequi.franchises.application.ports.input;

import com.nequi.franchises.domain.model.Product;

import java.util.List;

public interface ProductServicePort {
    Product findProduct(Long id);
    List<Product> findAllProducts();
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
