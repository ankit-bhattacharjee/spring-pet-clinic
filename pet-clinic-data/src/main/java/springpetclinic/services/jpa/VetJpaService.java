package springpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import springpetclinic.model.Owner;
import springpetclinic.model.Vet;
import springpetclinic.repositories.VetRepository;
import springpetclinic.services.VetDbService;

@Service
@Profile("spring-data-jpa")
public class VetJpaService extends AbstractJpaService<Vet, Long> implements VetDbService {

    protected VetJpaService(VetRepository repository) {
        super(repository);
    }

}
