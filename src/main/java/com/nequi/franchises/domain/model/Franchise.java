package com.nequi.franchises.domain.model;

import lombok.*;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Franchise {
    private String id;
    private String name;
}
