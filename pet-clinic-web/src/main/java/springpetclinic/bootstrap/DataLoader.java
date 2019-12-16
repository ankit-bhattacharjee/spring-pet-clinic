package springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springpetclinic.model.Owner;
import springpetclinic.model.Vet;
import springpetclinic.service.OwnerDbService;
import springpetclinic.service.VetDbService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerDbService ownerDbService;
    private final VetDbService vetDbService;

    public DataLoader(OwnerDbService ownerDbService, VetDbService vetDbService) {
        this.ownerDbService = ownerDbService;
        this.vetDbService = vetDbService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Myers");
        ownerDbService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Freddy");
        owner2.setLastName("Kruger");
        ownerDbService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(3L);
        vet1.setFirstName("Jason");
        vet1.setLastName("Vorhess");
        vetDbService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(4L);
        vet2.setFirstName("Chucky");
        vet2.setLastName("Chuck");
        vetDbService.save(vet2);

    }
}
