package com.nequi.franchises.infraestructure.adapters.output.persistence.mapper;

import com.nequi.franchises.domain.model.Franchise;
import com.nequi.franchises.infraestructure.adapters.output.persistence.entity.FranchiseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FranchisePersistenceMapper {

    FranchiseEntity toFranchiseEntity(Franchise franchise);
    Franchise toFranchise(FranchiseEntity entity);
}
