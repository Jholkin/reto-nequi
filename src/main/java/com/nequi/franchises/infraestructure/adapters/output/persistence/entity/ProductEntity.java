package com.nequi.franchises.infraestructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double stock;
    @ManyToOne
    @JoinColumn(name = "subsidiary_id")
    private SubsidiaryEntity subsidiaryEntity;
}
