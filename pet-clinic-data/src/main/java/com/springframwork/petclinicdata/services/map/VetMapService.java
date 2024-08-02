package com.springframwork.petclinicdata.services.map;

import com.springframwork.petclinicdata.model.Speciality;
import com.springframwork.petclinicdata.model.Vet;
import com.springframwork.petclinicdata.services.SpecialityService;
import com.springframwork.petclinicdata.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialities().isEmpty()) {
            object.getSpecialities().forEach(speciality -> {
              if(speciality.getId() == null) {
                  Speciality savedSpeciality = specialityService.save(speciality);
                  speciality.setId(savedSpeciality.getId());
              }
            });
        }

        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}
