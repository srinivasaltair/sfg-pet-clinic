package com.springframwork.petclinicdata.repositories;

import com.springframwork.petclinicdata.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
