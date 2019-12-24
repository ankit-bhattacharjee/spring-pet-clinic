package springpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springpetclinic.model.PetType;
import springpetclinic.services.PetTypeService;

@Service
@Profile("map")
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
