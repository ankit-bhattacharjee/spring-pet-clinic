package springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springpetclinic.model.Owner;
import springpetclinic.model.PetType;
import springpetclinic.model.Vet;
import springpetclinic.service.OwnerDbService;
import springpetclinic.service.PetTypeService;
import springpetclinic.service.VetDbService;

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
        owner1.setLastName("Myers");
        ownerDbService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Freddy");
        owner2.setLastName("Kruger");
        ownerDbService.save(owner2);

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
