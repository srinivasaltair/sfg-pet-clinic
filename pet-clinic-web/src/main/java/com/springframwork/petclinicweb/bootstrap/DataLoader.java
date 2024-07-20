package com.springframwork.petclinicweb.bootstrap;

import com.springframwork.petclinicdata.model.Owner;
import com.springframwork.petclinicdata.model.Vet;
import com.springframwork.petclinicdata.services.OwnerService;
import com.springframwork.petclinicdata.services.PetService;
import com.springframwork.petclinicdata.services.VetService;
import com.springframwork.petclinicdata.services.map.OwnerServiceMap;
import com.springframwork.petclinicdata.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;

public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Doe");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Jane");
        owner2.setLastName("Doe");
        ownerService.save(owner2);
        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("VJohn");
        vet1.setLastName("VDoe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vetService.save(vet2);
        System.out.println("Loaded Vets...");
    }
}
