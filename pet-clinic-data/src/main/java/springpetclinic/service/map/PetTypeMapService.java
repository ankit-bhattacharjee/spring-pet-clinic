package springpetclinic.service.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.PetType;
import springpetclinic.service.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
