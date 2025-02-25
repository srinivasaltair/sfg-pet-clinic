package com.springframwork.petclinicdata.repositories;

import com.springframwork.petclinicdata.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
