package com.nequi.franchises.infraestructure.adapters.output.persistence;

import com.nequi.franchises.application.ports.output.SubsidiaryPersistencePort;
import com.nequi.franchises.domain.model.ProductTop;
import com.nequi.franchises.domain.model.Subsidiary;
import com.nequi.franchises.infraestructure.adapters.output.persistence.mapper.PersistenceMapper;
import com.nequi.franchises.infraestructure.adapters.output.persistence.repository.SubsidiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SubsidiaryPersistenceAdapter implements SubsidiaryPersistencePort {
    private final SubsidiaryRepository subsidiaryRepository;
    private final PersistenceMapper subsidiaryMapper;

    @Override
    public Mono<Subsidiary> findById(long id) {
        return subsidiaryRepository.findById(id)
                .map(subsidiaryMapper::toSubsidiary);
    }

    @Override
    public Mono<Subsidiary> save(Subsidiary subsidiary) {
        return subsidiaryRepository.save(subsidiaryMapper.toSubsidiaryEntity(subsidiary))
                .map(subsidiaryMapper::toSubsidiary);
    }

    @Override
    public Flux<Subsidiary> findAll(long franchiseId) {
        return subsidiaryRepository.findByFranchiseId(franchiseId)
                .map(subsidiaryMapper::toSubsidiary);
    }

    @Override
    public Flux<ProductTop> findSubsidiariesWithProductMaxStock(Long franchiseId) {
        return subsidiaryRepository.findSubsidiariesWithProductMaxStock(franchiseId)
                .map(object -> ProductTop.builder()
                        .subsidiary(object[0].toString())
                        .product(object[1].toString())
                        .stock(Double.parseDouble(object[2].toString()))
                        .build());
    }
}
