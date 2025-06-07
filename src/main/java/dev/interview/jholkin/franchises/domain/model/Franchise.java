package dev.interview.jholkin.franchises.domain.model;

import lombok.*;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Franchise {
    private Long id;
    private String name;
}
