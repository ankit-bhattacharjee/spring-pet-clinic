package springpetclinic.service.map;

import springpetclinic.model.Pet;

public class PetServiceMap extends AbstractMapService<Pet, Long> {

    @Override
    public Pet save(Pet pet) {
        this.save(pet.getId(), pet);
        return pet;
    }
}
