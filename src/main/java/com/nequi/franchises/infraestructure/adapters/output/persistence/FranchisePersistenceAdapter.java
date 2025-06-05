package com.nequi.franchises.infraestructure.adapters.output.persistence;

import com.nequi.franchises.application.ports.output.FranchisePersistencePort;
import com.nequi.franchises.domain.model.Franchise;
import com.nequi.franchises.infraestructure.adapters.output.persistence.mapper.PersistenceMapper;
import com.nequi.franchises.infraestructure.adapters.output.persistence.repository.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FranchisePersistenceAdapter implements FranchisePersistencePort {

    private final FranchiseRepository franchiseRepository;
    private final PersistenceMapper franchiseMapper;

    @Override
    public Mono<Franchise> findById(Long id) {
        return franchiseRepository.findById(id)
                .map(franchiseMapper::toFranchise);
    }

    @Override
    public Mono<Franchise> save(Franchise franchise) {
        return franchiseRepository.save(franchiseMapper.toFranchiseEntity(franchise))
                .map(franchiseMapper::toFranchise);
    }

    @Override
    public Flux<Franchise> findAll() {
        return franchiseRepository.findAll()
                .map(franchiseMapper::toFranchise);
    }
}
