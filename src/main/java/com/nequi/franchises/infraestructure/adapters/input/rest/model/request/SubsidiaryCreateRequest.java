package com.nequi.franchises.infraestructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubsidiaryCreateRequest {
    @NotBlank
    private String name;
    @NotNull
    private long franchiseId;
}
