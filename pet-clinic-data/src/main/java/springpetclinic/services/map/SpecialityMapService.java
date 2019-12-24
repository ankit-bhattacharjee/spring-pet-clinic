package springpetclinic.services.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.Specialty;
import springpetclinic.services.SpecialtyService;

@Service
public class SpecialityMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
}
