package springpetclinic.service.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.Pet;
import springpetclinic.service.PetDbService;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetDbService {
}
