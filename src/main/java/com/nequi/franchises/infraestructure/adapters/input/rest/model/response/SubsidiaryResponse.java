package com.nequi.franchises.infraestructure.adapters.input.rest.model.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubsidiaryResponse {
    private Long id;
    private String name;
}
