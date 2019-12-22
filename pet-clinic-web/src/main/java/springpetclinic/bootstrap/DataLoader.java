package springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springpetclinic.model.*;
import springpetclinic.service.OwnerDbService;
import springpetclinic.service.PetTypeService;
import springpetclinic.service.SpecialtyService;
import springpetclinic.service.VetDbService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerDbService ownerDbService;
    private final VetDbService vetDbService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerDbService ownerDbService, VetDbService vetDbService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerDbService = ownerDbService;
        this.vetDbService = vetDbService;
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
        ownerDbService.save(owner1);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(dog);
        mikesPet.setName("Rosco");
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Glen");
        ownerDbService.save(owner2);

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
        vetDbService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vet2.getSpecialities().add(nursery);
        vetDbService.save(vet2);
    }
}
