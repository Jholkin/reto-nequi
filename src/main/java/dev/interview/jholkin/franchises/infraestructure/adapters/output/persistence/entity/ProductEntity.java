package dev.interview.jholkin.franchises.infraestructure.adapters.output.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class ProductEntity {
    @Id
    private Long id;
    private String name;
    private double stock;
    private Long subsidiaryId;
}
