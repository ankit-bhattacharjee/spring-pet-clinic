package springpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springpetclinic.model.Specialty;
import springpetclinic.services.SpecialtyService;

@Service
@Profile("map")
public class SpecialityMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
}
