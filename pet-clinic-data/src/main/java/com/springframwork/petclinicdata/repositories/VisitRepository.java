package com.springframwork.petclinicdata.repositories;

import com.springframwork.petclinicdata.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
