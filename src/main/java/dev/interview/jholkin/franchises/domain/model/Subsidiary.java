package dev.interview.jholkin.franchises.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subsidiary {
    private Long id;
    private String name;
    private Long franchiseId;
}
