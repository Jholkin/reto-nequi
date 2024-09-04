package com.nequi.franchises.infraestructure.adapters.output.persistence.mapper;

import com.nequi.franchises.domain.model.Franchise;
import com.nequi.franchises.domain.model.Product;
import com.nequi.franchises.domain.model.Subsidiary;
import com.nequi.franchises.infraestructure.adapters.output.persistence.entity.FranchiseEntity;
import com.nequi.franchises.infraestructure.adapters.output.persistence.entity.ProductEntity;
import com.nequi.franchises.infraestructure.adapters.output.persistence.entity.SubsidiaryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersistenceMapper {

    FranchiseEntity toFranchiseEntity(Franchise franchise);
    Franchise toFranchise(FranchiseEntity entity);
    List<Franchise> toFranchiseList(List<FranchiseEntity> entityList);

    @Mapping(target = "franchise.id", source = "franchiseId")
    SubsidiaryEntity toSubsidiaryEntity(Subsidiary entity);
    Subsidiary toSubsidiary(SubsidiaryEntity entity);
    List<Subsidiary> toSubsidiaryList(List<SubsidiaryEntity> entityList);

    @Mapping(target = "subsidiaryEntity.id", source = "subsidiaryId")
    ProductEntity toProductEntity(Product product);
    Product toProduct(ProductEntity entity);
    List<Product> toProductList(List<ProductEntity> entityList);
}
