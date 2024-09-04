package com.nequi.franchises.application.services;

import com.nequi.franchises.application.ports.input.SubsidiaryServicePort;
import com.nequi.franchises.application.ports.output.SubsidiaryPersistencePort;
import com.nequi.franchises.domain.exception.SubsidiaryNotFoundException;
import com.nequi.franchises.domain.model.ProductTop;
import com.nequi.franchises.domain.model.Subsidiary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubsidiaryService implements SubsidiaryServicePort {
    private final SubsidiaryPersistencePort subsidiaryPersistencePort;

    @Override
    public Subsidiary findById(long id) {
        return subsidiaryPersistencePort.findById(id)
                .orElseThrow(SubsidiaryNotFoundException::new);
    }

    @Override
    public List<Subsidiary> findAll(long franchiseId) {
        return subsidiaryPersistencePort.findAll(franchiseId);
    }

    @Override
    public Subsidiary save(Subsidiary subsidiary) {
        return subsidiaryPersistencePort.save(subsidiary);
    }

    @Override
    public Subsidiary update(long id, Subsidiary subsidiary) {
        return subsidiaryPersistencePort.findById(id)
                .map(savedSubsidiary -> {
                    savedSubsidiary.setName(subsidiary.getName());
                    savedSubsidiary.setFranchise(savedSubsidiary.getFranchise());
                    return subsidiaryPersistencePort.save(savedSubsidiary);
                })
                .orElseThrow(SubsidiaryNotFoundException::new);
    }

    @Override
    public List<ProductTop> findSubsidiariesWithProductMaxStock(Long franchiseId) {
        return subsidiaryPersistencePort.findSubsidiariesWithProductMaxStock(franchiseId);
    }
}
