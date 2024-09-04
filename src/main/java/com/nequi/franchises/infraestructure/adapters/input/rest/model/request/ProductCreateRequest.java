package com.nequi.franchises.infraestructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {
    @NotBlank
    private String name;
    @NotNull
    private double stock;
    @NotNull
    private long subsidiaryId;
}
