package springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springpetclinic.model.Owner;
import springpetclinic.model.Pet;
import springpetclinic.model.PetType;
import springpetclinic.model.Vet;
import springpetclinic.service.OwnerDbService;
import springpetclinic.service.PetTypeService;
import springpetclinic.service.VetDbService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerDbService ownerDbService;
    private final VetDbService vetDbService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerDbService ownerDbService, VetDbService vetDbService, PetTypeService petTypeService) {
        this.ownerDbService = ownerDbService;
        this.vetDbService = vetDbService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Rune");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Glyph");
        petTypeService.save(cat);

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
        vet1.setFirstName("Jason");
        vet1.setLastName("Vorhess");
        vetDbService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Chucky");
        vet2.setLastName("Chuck");
        vetDbService.save(vet2);

    }
}
