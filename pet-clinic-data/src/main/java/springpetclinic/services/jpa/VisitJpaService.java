package springpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import springpetclinic.model.Visit;
import springpetclinic.services.VisitService;

@Service
@Profile("spring-data-jpa")
public class VisitJpaService extends AbstractJpaService<Visit, Long> implements VisitService {
    protected VisitJpaService(CrudRepository<Visit, Long> repository) {
        super(repository);
    }
}
