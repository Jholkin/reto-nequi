package com.nequi.franchises.infraestructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "franchises")
public class FranchiseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "franchise")
    private List<SubsidiaryEntity> subsidiaries;
}
