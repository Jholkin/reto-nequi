package com.nequi.franchises.infraestructure.adapters.input.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class SubsidiaryHandler {

    public Mono<ServerResponse> create(ServerRequest request) {
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> deleteSubsidiary(ServerRequest request) {
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> getByFranchiseId(ServerRequest request) {
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> topProducts(ServerRequest request) {
        return ServerResponse.ok().bodyValue("");
    }
}
