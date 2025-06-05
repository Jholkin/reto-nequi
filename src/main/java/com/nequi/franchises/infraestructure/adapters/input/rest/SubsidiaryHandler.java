package com.nequi.franchises.infraestructure.adapters.input.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class SubsidiaryHandler {

    public Mono<ServerResponse> createSubsidiary(ServerRequest request) {
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> deleteSubsidiary(ServerRequest request) {
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> getSubsidiaryByFranchiseId(ServerRequest request) {
        return ServerResponse.ok().bodyValue("");
    }
}
