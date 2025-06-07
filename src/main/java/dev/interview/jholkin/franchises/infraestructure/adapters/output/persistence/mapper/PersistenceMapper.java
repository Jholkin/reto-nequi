package dev.interview.jholkin.franchises.infraestructure.adapters.output.persistence.mapper;

import dev.interview.jholkin.franchises.domain.model.Franchise;
import dev.interview.jholkin.franchises.domain.model.Product;
import dev.interview.jholkin.franchises.domain.model.Subsidiary;
import dev.interview.jholkin.franchises.infraestructure.adapters.output.persistence.entity.FranchiseEntity;
import dev.interview.jholkin.franchises.infraestructure.adapters.output.persistence.entity.ProductEntity;
import dev.interview.jholkin.franchises.infraestructure.adapters.output.persistence.entity.SubsidiaryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersistenceMapper {

    FranchiseEntity toFranchiseEntity(Franchise franchise);
    Franchise toFranchise(FranchiseEntity entity);

    SubsidiaryEntity toSubsidiaryEntity(Subsidiary entity);
    Subsidiary toSubsidiary(SubsidiaryEntity entity);

    ProductEntity toProductEntity(Product product);
    Product toProduct(ProductEntity entity);
}
