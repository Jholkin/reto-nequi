package com.nequi.franchises.application.services;

import com.nequi.franchises.application.ports.input.SubsidiaryServicePort;
import com.nequi.franchises.application.ports.output.SubsidiaryPersistencePort;
import com.nequi.franchises.domain.model.ProductTop;
import com.nequi.franchises.domain.model.Subsidiary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SubsidiaryService implements SubsidiaryServicePort {
    private final SubsidiaryPersistencePort subsidiaryPersistencePort;

    @Override
    public Mono<Subsidiary> findById(long id) {
        return subsidiaryPersistencePort.findById(id);
    }

    @Override
    public Flux<Subsidiary> findAll(long franchiseId) {
        return subsidiaryPersistencePort.findAll(franchiseId);
    }

    @Override
    public Mono<Subsidiary> save(Subsidiary subsidiary) {
        return subsidiaryPersistencePort.save(subsidiary);
    }

    @Override
    public Mono<Subsidiary> update(long id, Subsidiary subsidiary) {
        return subsidiaryPersistencePort.findById(id)
                .flatMap(savedSubsidiary -> {
                    savedSubsidiary.setName(subsidiary.getName());
                    savedSubsidiary.setFranchiseId(savedSubsidiary.getFranchiseId());
                    return subsidiaryPersistencePort.save(savedSubsidiary);
                });
    }

    @Override
    public Flux<ProductTop> findSubsidiariesWithProductMaxStock(Long franchiseId) {
        return subsidiaryPersistencePort.findSubsidiariesWithProductMaxStock(franchiseId);
    }
}
