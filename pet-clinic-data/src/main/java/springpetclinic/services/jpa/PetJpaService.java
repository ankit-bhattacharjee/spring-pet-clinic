package springpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springpetclinic.model.Pet;
import springpetclinic.repositories.PetRepository;
import springpetclinic.services.PetService;

@Service
@Profile("spring-data-jpa")
public class PetJpaService extends AbstractJpaService<Pet, Long> implements PetService {
    protected PetJpaService(PetRepository repository) {
        super(repository);
    }
}
