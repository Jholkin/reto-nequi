package com.nequi.franchises.infraestructure.adapters.output.persistence;

import com.nequi.franchises.application.ports.output.FranchisePersistencePort;
import com.nequi.franchises.domain.model.Franchise;
import com.nequi.franchises.infraestructure.adapters.output.persistence.mapper.PersistenceMapper;
import com.nequi.franchises.infraestructure.adapters.output.persistence.repository.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FranchisePersistenceAdapter implements FranchisePersistencePort {

    private final FranchiseRepository franchiseRepository;
    private final PersistenceMapper franchiseMapper;

    @Override
    public Optional<Franchise> findById(Long id) {
        return franchiseRepository.findById(id)
                .map(franchiseMapper::toFranchise);
    }

    @Override
    public Franchise save(Franchise franchise) {
        return franchiseMapper.toFranchise(
                franchiseRepository.save(franchiseMapper.toFranchiseEntity(franchise)));
    }

    @Override
    public List<Franchise> findAll() {
        return franchiseMapper.toFranchiseList(franchiseRepository.findAll());
    }
}
