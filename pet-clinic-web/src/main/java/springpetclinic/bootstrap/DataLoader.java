package springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springpetclinic.model.Owner;
import springpetclinic.model.Vet;
import springpetclinic.service.OwnerDbService;
import springpetclinic.service.VetDbService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerDbService ownerService;
    private final VetDbService vetDbService;

    public DataLoader(OwnerDbService ownerService, VetDbService vetDbService) {
        this.ownerService = ownerService;
        this.vetDbService = vetDbService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Myers");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Freddy");
        owner2.setLastName("Kruger");

        Vet vet1 = new Vet();
        vet1.setId(3L);
        vet1.setFirstName("Jason");
        vet1.setLastName("Vorhess");

        Vet vet2 = new Vet();
        vet2.setId(4L);
        vet2.setFirstName("Chucky");
        vet2.setLastName("Chuck");


    }
}
