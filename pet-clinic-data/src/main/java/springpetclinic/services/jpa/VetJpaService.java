package springpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springpetclinic.model.Vet;
import springpetclinic.repositories.VetRepository;
import springpetclinic.services.VetService;

@Service
@Profile("spring-data-jpa")
public class VetJpaService extends AbstractJpaService<Vet, Long> implements VetService {

    protected VetJpaService(VetRepository repository) {
        super(repository);
    }

}
