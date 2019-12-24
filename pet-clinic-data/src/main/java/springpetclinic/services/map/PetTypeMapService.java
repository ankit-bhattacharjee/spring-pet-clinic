package springpetclinic.services.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.PetType;
import springpetclinic.services.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
