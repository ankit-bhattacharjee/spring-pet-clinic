package springpetclinic.service.map;

import springpetclinic.model.Pet;
import springpetclinic.service.PetDbService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetDbService {

    @Override
    public Pet save(Pet pet) {
        this.save(pet.getId(), pet);
        return pet;
    }
}
