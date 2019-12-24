package springpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springpetclinic.model.Pet;
import springpetclinic.services.PetService;

@Service
@Profile("map")
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
}
