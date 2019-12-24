package springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springpetclinic.model.*;
import springpetclinic.services.OwnerService;
import springpetclinic.services.PetTypeService;
import springpetclinic.services.SpecialtyService;
import springpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0)
            loadData();

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Rune");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Glyph");
        petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        specialtyService.save(radiology);

        Specialty nursery = new Specialty();
        nursery.setDescription("Nursery");
        specialtyService.save(nursery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(dog);
        mikesPet.setName("Rosco");
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Glen");
        ownerService.save(owner2);

        Pet fionnasPet = new Pet();
        fionnasPet.setPetType(cat);
        fionnasPet.setName("Snowy");
        fionnasPet.setOwner(owner2);
        fionnasPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionnasPet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Jessie");
        vet1.setLastName("Porter");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vet2.getSpecialities().add(nursery);
        vetService.save(vet2);
    }
}
