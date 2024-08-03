package com.springframwork.petclinicdata.repositories;

import com.springframwork.petclinicdata.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
