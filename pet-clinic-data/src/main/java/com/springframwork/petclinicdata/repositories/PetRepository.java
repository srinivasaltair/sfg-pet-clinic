package com.springframwork.petclinicdata.repositories;

import com.springframwork.petclinicdata.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
