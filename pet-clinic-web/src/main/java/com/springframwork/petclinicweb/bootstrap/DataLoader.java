package com.springframwork.petclinicweb.bootstrap;

import com.springframwork.petclinicdata.model.*;
import com.springframwork.petclinicdata.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            dataLoader();
        }
    }

    private void dataLoader() {
        PetType dog = new PetType();
        dog.setName("Dog1");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat1");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Doe");
        Owner.builder().address("NY").city("Maimi").telephone("+1323423").build();

        Pet johnPet = new Pet();
        johnPet.setOwner(owner1);
        johnPet.setPetType(savedDogType);
        johnPet.setBirthDate(LocalDate.now());
        johnPet.setName("Summer");
        owner1.getPets().add(johnPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jane");
        owner2.setLastName("Doe");
        ownerService.save(owner2);

        Pet janePet = new Pet();
        janePet.setOwner(owner2);
        janePet.setPetType(savedCatType);
        janePet.setBirthDate(LocalDate.now());
        janePet.setName("June");
        owner2.getPets().add(janePet);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("VJohn");
        vet1.setLastName("VDoe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("Loaded Vets...");

        Visit dogVisit = new Visit();
        dogVisit.setPet(johnPet);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Dog Visit");
        visitService.save(dogVisit);
    }
}
