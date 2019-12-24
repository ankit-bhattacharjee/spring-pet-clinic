package springpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springpetclinic.model.Owner;
import springpetclinic.repositories.OwnerRepository;
import springpetclinic.services.OwnerDbService;

@Service
@Profile("spring-data-jpa")
public class OwnerJpaService extends AbstractJpaService<Owner, Long> implements OwnerDbService {

    public OwnerJpaService(OwnerRepository repository) {
        super(repository);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ((OwnerRepository) repository).findByLastName(lastName);
    }
}
