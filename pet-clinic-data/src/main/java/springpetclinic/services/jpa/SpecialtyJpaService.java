package springpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import springpetclinic.model.Specialty;
import springpetclinic.services.SpecialtyService;

@Service
@Profile("spring-data-jpa")
public class SpecialtyJpaService extends AbstractJpaService<Specialty, Long> implements SpecialtyService {
    protected SpecialtyJpaService(CrudRepository<Specialty, Long> repository) {
        super(repository);
    }
}
