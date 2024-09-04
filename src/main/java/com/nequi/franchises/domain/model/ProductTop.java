package com.nequi.franchises.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductTop {
    private String subsidiary;
    private String product;
    private double stock;
}
