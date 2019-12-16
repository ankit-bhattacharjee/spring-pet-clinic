package springpetclinic.service.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.Pet;
import springpetclinic.service.PetDbService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetDbService {

    @Override
    public Pet save(Pet pet) {
        this.save(pet.getId(), pet);
        return pet;
    }
}
