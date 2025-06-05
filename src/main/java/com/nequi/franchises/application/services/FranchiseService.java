package com.nequi.franchises.application.services;

import com.nequi.franchises.application.ports.input.FranchiseServicePort;
import com.nequi.franchises.application.ports.output.FranchisePersistencePort;
import com.nequi.franchises.domain.model.Franchise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FranchiseService implements FranchiseServicePort {

    private final FranchisePersistencePort franchisePersistencePort;

    @Override
    public Mono<Franchise> save(Franchise franchise) {
        return franchisePersistencePort.save(franchise);
    }

    @Override
    public Mono<Franchise> findById(Long id) {
        return franchisePersistencePort.findById(id);
    }

    @Override
    public Mono<Franchise> update(Long id, Franchise franchise) {
        return franchisePersistencePort.findById(id)
                .flatMap(savedFranchise -> {
                    savedFranchise.setName(franchise.getName());
                    return franchisePersistencePort.save(savedFranchise);
                });
    }

    @Override
    public Flux<Franchise> findAll() {
        return franchisePersistencePort.findAll();
    }
}
