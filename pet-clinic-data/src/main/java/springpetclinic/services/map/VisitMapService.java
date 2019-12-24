package springpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springpetclinic.model.Visit;
import springpetclinic.services.CrudService;
import springpetclinic.services.VisitService;

@Service
@Profile("map")
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
}
