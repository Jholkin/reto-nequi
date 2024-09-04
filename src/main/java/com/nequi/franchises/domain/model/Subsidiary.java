package com.nequi.franchises.domain.model;

import com.nequi.franchises.infraestructure.adapters.output.persistence.entity.FranchiseEntity;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subsidiary {
    private Long id;
    private String name;
    private Long franchiseId;
    private FranchiseEntity franchise;
}
