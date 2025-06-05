package com.nequi.franchises.infraestructure.adapters.input.rest;

import com.nequi.franchises.application.ports.input.FranchiseServicePort;
import com.nequi.franchises.infraestructure.adapters.input.rest.mapper.RestMapper;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.request.FranchiseCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FranchiseHandler {
    private final RestMapper restMapper;
    private final FranchiseServicePort franchiseServicePort;

    public Mono<ServerResponse> getFranchiseById(ServerRequest request) {
        String id = request.pathVariable("id");
        return franchiseServicePort.findById(Long.parseLong(id))
                .flatMap(franchise -> ServerResponse.ok().bodyValue(restMapper.toFranchiseResponse(franchise)));
    }

    public Mono<ServerResponse> createFranchise(ServerRequest request) {
        return request.bodyToMono(FranchiseCreateRequest.class)
                .map(restMapper::toFranchise)
                .flatMap(franchiseServicePort::save)
                .flatMap(franchise -> ServerResponse.ok().bodyValue(restMapper.toFranchiseResponse(franchise)));
    }

    public Mono<ServerResponse> updateFranchise(ServerRequest request) {
        String id = request.pathVariable("id");
        return request.bodyToMono(FranchiseCreateRequest.class)
                .map(restMapper::toFranchise)
                .flatMap(franchise -> franchiseServicePort.update(Long.parseLong(id), franchise))
                .flatMap(franchise -> ServerResponse.ok().bodyValue(restMapper.toFranchiseResponse(franchise)));
    }

    public Mono<ServerResponse> listFranchises(ServerRequest request) {
        return franchiseServicePort.findAll()
                .collectList()
                .flatMap(franchises -> ServerResponse.ok().bodyValue(franchises));
    }
}
