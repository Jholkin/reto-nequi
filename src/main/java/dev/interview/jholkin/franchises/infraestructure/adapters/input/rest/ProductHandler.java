package dev.interview.jholkin.franchises.infraestructure.adapters.input.rest;

import dev.interview.jholkin.franchises.application.ports.input.ProductServicePort;
import dev.interview.jholkin.franchises.infraestructure.adapters.input.rest.mapper.RestMapper;
import dev.interview.jholkin.franchises.infraestructure.adapters.input.rest.model.request.ProductCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductHandler {
    private final ProductServicePort productServicePort;
    private final RestMapper restMapper;

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(ProductCreateRequest.class)
                .map(restMapper::toProduct)
                .flatMap(productServicePort::createProduct)
                .flatMap(result -> ServerResponse.ok().bodyValue(result));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        String id = request.pathVariable("id");
        return request.bodyToMono(ProductCreateRequest.class)
                .map(restMapper::toProduct)
                .flatMap(product -> productServicePort.updateProduct(Long.parseLong(id), product))
                .flatMap(result -> ServerResponse.ok().bodyValue(restMapper.toProductResponse(result)));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        String id = request.pathVariable("id");
        return productServicePort.deleteProduct(Long.parseLong(id))
                .then(Mono.defer(() -> ServerResponse.ok().bodyValue("")));
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        String id = request.pathVariable("id");
        return productServicePort.findProduct(Long.parseLong(id))
                .flatMap(result -> ServerResponse.ok().bodyValue(restMapper.toProductResponse(result)));
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return productServicePort.findAllProducts()
                .collectList()
                .flatMap(result -> ServerResponse.ok().bodyValue(result));

    }
}
