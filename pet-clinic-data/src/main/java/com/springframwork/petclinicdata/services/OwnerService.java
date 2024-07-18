package com.springframwork.petclinicdata.services;

import com.springframwork.petclinicdata.model.Owner;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
