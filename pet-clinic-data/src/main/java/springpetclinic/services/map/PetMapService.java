package springpetclinic.services.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.Pet;
import springpetclinic.services.PetDbService;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetDbService {
}
