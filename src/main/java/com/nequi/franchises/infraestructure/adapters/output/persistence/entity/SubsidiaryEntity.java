package com.nequi.franchises.infraestructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subsidiaries")
public class SubsidiaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private FranchiseEntity franchise;
    @OneToMany(mappedBy = "subsidiaryEntity")
    private List<ProductEntity> products = new ArrayList<>();
}
