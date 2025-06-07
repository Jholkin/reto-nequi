package dev.interview.jholkin.franchises.infraestructure.adapters.input.rest;

import dev.interview.jholkin.franchises.application.ports.input.SubsidiaryServicePort;
import dev.interview.jholkin.franchises.infraestructure.adapters.input.rest.mapper.RestMapper;
import dev.interview.jholkin.franchises.infraestructure.adapters.input.rest.model.request.SubsidiaryCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SubsidiaryHandler {
    private final RestMapper restMapper;
    private final SubsidiaryServicePort subsidiaryServicePort;

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(SubsidiaryCreateRequest.class)
                .map(restMapper::toSubsidiary)
                .flatMap(subsidiaryServicePort::save)
                .flatMap(subsidiary -> ServerResponse.ok().bodyValue(restMapper.toSubsidiaryResponse(subsidiary)));
    }

    public Mono<ServerResponse> deleteSubsidiary(ServerRequest request) {
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> getByFranchiseId(ServerRequest request) {
        String id = request.pathVariable("id");
        return subsidiaryServicePort.findAll(Long.parseLong(id))
                .collectList()
                .flatMap(subsidiaries -> ServerResponse.ok().bodyValue(subsidiaries));
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        String id = request.pathVariable("id");
        return subsidiaryServicePort.findById(Long.parseLong(id))
                .flatMap(subsidiary -> ServerResponse.ok().bodyValue(restMapper.toSubsidiaryResponse(subsidiary)));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        String id = request.pathVariable("id");
        return request.bodyToMono(SubsidiaryCreateRequest.class)
                .map(restMapper::toSubsidiary)
                .flatMap(subsidiary -> subsidiaryServicePort.update(Long.parseLong(id), subsidiary))
                .flatMap(subsidiary -> ServerResponse.ok().bodyValue(restMapper.toSubsidiaryResponse(subsidiary)));
    }

    public Mono<ServerResponse> topProducts(ServerRequest request) {
        return ServerResponse.ok().bodyValue("");
    }
}
