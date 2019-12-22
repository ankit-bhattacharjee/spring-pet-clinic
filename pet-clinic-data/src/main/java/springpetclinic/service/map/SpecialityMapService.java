package springpetclinic.service.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.Specialty;
import springpetclinic.service.SpecialtyService;

@Service
public class SpecialityMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
}
