package com.nequi.franchises.application.ports.input;

import com.nequi.franchises.domain.model.Franchise;

import java.util.List;

public interface FranchiseServicePort {
    Franchise save(Franchise franchise);
    Franchise findById(Long id);
    Franchise update(Long id, Franchise franchise);
    List<Franchise> findAll();
}
