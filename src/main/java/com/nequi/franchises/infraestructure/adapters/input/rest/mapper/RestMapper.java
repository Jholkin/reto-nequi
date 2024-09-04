package com.nequi.franchises.infraestructure.adapters.input.rest.mapper;

import com.nequi.franchises.domain.model.Franchise;
import com.nequi.franchises.domain.model.Product;
import com.nequi.franchises.domain.model.Subsidiary;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.request.FranchiseCreateRequest;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.request.ProductCreateRequest;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.request.SubsidiaryCreateRequest;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.response.FranchiseResponse;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.response.ProductResponse;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.response.SubsidiaryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestMapper {
    Franchise toFranchise(FranchiseCreateRequest franchise);
    FranchiseResponse toFranchiseResponse(Franchise franchise);
    List<FranchiseResponse> toFranchiseResponseList(List<Franchise> franchiseList);

    Subsidiary toSubsidiary(SubsidiaryCreateRequest subsidiary);
    SubsidiaryResponse toSubsidiaryResponse(Subsidiary subsidiary);
    List<SubsidiaryResponse> toSubsidiaryResponseList(List<Subsidiary> subsidiaryList);

    ProductResponse toProductResponse(Product product);
    Product toProduct(ProductCreateRequest product);
    List<ProductResponse> toProductResponseList(List<Product> productList);
}
