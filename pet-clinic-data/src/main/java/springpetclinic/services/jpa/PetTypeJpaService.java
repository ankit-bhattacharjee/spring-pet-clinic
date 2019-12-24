package springpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springpetclinic.model.PetType;
import springpetclinic.repositories.PetTypeRepository;
import springpetclinic.services.PetTypeService;

@Service
@Profile("spring-data-jpa")
public class PetTypeJpaService extends AbstractJpaService<PetType, Long> implements PetTypeService {
    protected PetTypeJpaService(PetTypeRepository repository) {
        super(repository);
    }
}
