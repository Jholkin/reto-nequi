package com.nequi.franchises.application.ports.input;

import com.nequi.franchises.domain.model.ProductTop;
import com.nequi.franchises.domain.model.Subsidiary;

import java.util.List;

public interface SubsidiaryServicePort {
    Subsidiary findById(long id);
    List<Subsidiary> findAll();
    Subsidiary save(Subsidiary subsidiary);
    Subsidiary update(long id, Subsidiary subsidiary);
    List<ProductTop> findSubsidiariesWithProductMaxStock(Long franchiseId);
}
