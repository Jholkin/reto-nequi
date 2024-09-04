package com.nequi.franchises.infraestructure.adapters.input.rest.mapper;

import com.nequi.franchises.domain.model.Franchise;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.request.FranchiseCreateRequest;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.response.FranchiseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FranchiseRestMapper {
    Franchise toFranchise(FranchiseCreateRequest franchise);
    FranchiseResponse toFranchiseResponse(Franchise franchise);
}
