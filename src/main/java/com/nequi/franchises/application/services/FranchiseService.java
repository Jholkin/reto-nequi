package com.nequi.franchises.application.services;

import com.nequi.franchises.application.ports.input.FranchiseServicePort;
import com.nequi.franchises.application.ports.output.FranchisePersistencePort;
import com.nequi.franchises.domain.exception.FranchiseNotFoundException;
import com.nequi.franchises.domain.model.Franchise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FranchiseService implements FranchiseServicePort {

    private final FranchisePersistencePort franchisePersistencePort;

    @Override
    public Franchise save(Franchise franchise) {
        return franchisePersistencePort.save(franchise);
    }

    @Override
    public Franchise findById(Long id) {
        return franchisePersistencePort.findById(id)
                .orElseThrow(FranchiseNotFoundException::new);
    }

    @Override
    public Franchise update(Long id, Franchise franchise) {
        return franchisePersistencePort.findById(id)
                .map(savedFranchise -> {
                    savedFranchise.setName(franchise.getName());
                    return franchisePersistencePort.save(savedFranchise);
                })
                .orElseThrow(FranchiseNotFoundException::new);
    }

    @Override
    public List<Franchise> findAll() {
        return franchisePersistencePort.findAll();
    }
}
