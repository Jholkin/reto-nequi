package com.nequi.franchises.infraestructure.adapters.input.rest;

import com.nequi.franchises.application.ports.input.ProductServicePort;
import com.nequi.franchises.infraestructure.adapters.input.rest.mapper.RestMapper;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.request.ProductCreateRequest;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.request.SubsidiaryCreateRequest;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.response.ProductResponse;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.response.SubsidiaryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductRestAdapter {
    private final ProductServicePort productService;
    private final RestMapper productMapper;

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productMapper.toProductResponse(productService.findProduct(id));
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return productMapper.toProductResponseList(productService.findAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductResponse> save(@RequestBody ProductCreateRequest product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productMapper.toProductResponse(productService.createProduct(productMapper.toProduct(product))));
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @RequestBody ProductCreateRequest product) {
        return productMapper.toProductResponse(
                productService.updateProduct(id, productMapper.toProduct(product))
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
