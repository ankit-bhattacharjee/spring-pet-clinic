package springpetclinic.services.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.Owner;
import springpetclinic.model.Pet;
import springpetclinic.services.OwnerDbService;
import springpetclinic.services.PetDbService;
import springpetclinic.services.PetTypeService;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerDbService {

    private final PetTypeService petTypeService;
    private final PetDbService petService;

    public OwnerMapService(PetTypeService petTypeService, PetDbService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null)
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                    } else throw new RuntimeException("Pet Type is required!");
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else return null;
    }
}
