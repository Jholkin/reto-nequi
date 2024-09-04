package com.nequi.franchises.infraestructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class FranchiseCreateRequest {
    @NotBlank(message = "Field name cannot be empty or null")
    private String name;
}
