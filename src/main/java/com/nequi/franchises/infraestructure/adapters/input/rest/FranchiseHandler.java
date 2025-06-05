package com.nequi.franchises.infraestructure.adapters.input.rest;

import com.nequi.franchises.infraestructure.adapters.input.rest.model.response.FranchiseResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class FranchiseHandler {

    public Mono<ServerResponse> getFranchiseById(ServerRequest request) {
        return ServerResponse.ok().bodyValue(FranchiseResponse.builder().build());
    }

    public Mono<ServerResponse> createFranchise(ServerRequest request) {
        return ServerResponse.ok().bodyValue(FranchiseResponse.builder().build());
    }

    public Mono<ServerResponse> updateFranchise(ServerRequest request) {
        return ServerResponse.ok().bodyValue(FranchiseResponse.builder().build());
    }

    public Mono<ServerResponse> listFranchises(ServerRequest request) {
        return ServerResponse.ok().bodyValue(FranchiseResponse.builder().build());
    }
}
