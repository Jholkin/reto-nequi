package dev.interview.jholkin.franchises.infraestructure.adapters.output.persistence.repository;

import dev.interview.jholkin.franchises.infraestructure.adapters.output.persistence.entity.FranchiseEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FranchiseRepository extends ReactiveCrudRepository<FranchiseEntity, Long> {
}
