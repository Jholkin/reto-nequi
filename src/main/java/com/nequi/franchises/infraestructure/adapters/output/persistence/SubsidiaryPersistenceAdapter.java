package com.nequi.franchises.infraestructure.adapters.output.persistence;

import com.nequi.franchises.application.ports.output.SubsidiaryPersistencePort;
import com.nequi.franchises.domain.model.ProductTop;
import com.nequi.franchises.domain.model.Subsidiary;
import com.nequi.franchises.infraestructure.adapters.output.persistence.mapper.PersistenceMapper;
import com.nequi.franchises.infraestructure.adapters.output.persistence.repository.SubsidiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SubsidiaryPersistenceAdapter implements SubsidiaryPersistencePort {
    private final SubsidiaryRepository subsidiaryRepository;
    private final PersistenceMapper subsidiaryMapper;

    @Override
    public Optional<Subsidiary> findById(long id) {
        return subsidiaryRepository.findById(id)
                .map(subsidiaryMapper::toSubsidiary);
    }

    @Override
    public Subsidiary save(Subsidiary subsidiary) {
        return subsidiaryMapper.toSubsidiary(
                subsidiaryRepository.save(subsidiaryMapper.toSubsidiaryEntity(subsidiary))
        );
    }

    @Override
    public List<Subsidiary> findAll() {
        return subsidiaryMapper.toSubsidiaryList(subsidiaryRepository.findAll());
    }

    @Override
    public List<ProductTop> findSubsidiariesWithProductMaxStock(Long franchiseId) {
        return subsidiaryRepository.findSubsidiariesWithProductMaxStock(franchiseId)
                .stream().map(object -> ProductTop.builder()
                        .subsidiary(object[0].toString())
                        .product(object[1].toString())
                        .stock(Double.parseDouble(object[2].toString()))
                        .build())
                .collect(Collectors.toList());
    }
}
