package dev.interview.jholkin.franchises.infraestructure.adapters.input.rest.mapper;

import dev.interview.jholkin.franchises.domain.model.Franchise;
import dev.interview.jholkin.franchises.domain.model.Product;
import dev.interview.jholkin.franchises.domain.model.ProductTop;
import dev.interview.jholkin.franchises.domain.model.Subsidiary;
import dev.interview.jholkin.franchises.infraestructure.adapters.input.rest.model.request.FranchiseCreateRequest;
import dev.interview.jholkin.franchises.infraestructure.adapters.input.rest.model.request.ProductCreateRequest;
import dev.interview.jholkin.franchises.infraestructure.adapters.input.rest.model.request.SubsidiaryCreateRequest;
import dev.interview.jholkin.franchises.infraestructure.adapters.input.rest.model.response.FranchiseResponse;
import dev.interview.jholkin.franchises.infraestructure.adapters.input.rest.model.response.ProductResponse;
import dev.interview.jholkin.franchises.infraestructure.adapters.input.rest.model.response.SubsidiaryResponse;
import dev.interview.jholkin.franchises.infraestructure.adapters.input.rest.model.response.SubsidiaryWithProductMaxStock;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestMapper {
    Franchise toFranchise(FranchiseCreateRequest franchise);
    FranchiseResponse toFranchiseResponse(Franchise franchise);

    Subsidiary toSubsidiary(SubsidiaryCreateRequest subsidiary);
    SubsidiaryResponse toSubsidiaryResponse(Subsidiary subsidiary);
    List<SubsidiaryWithProductMaxStock> toSubsidiaryWithProductMaxStock(List<ProductTop> productTopList);

    ProductResponse toProductResponse(Product product);
    Product toProduct(ProductCreateRequest product);
}
