package springpetclinic.service.map;

import springpetclinic.model.Owner;
import springpetclinic.service.OwnerDbService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerDbService {

    @Override
    public Owner save(Owner owner) {
        this.save(owner.getId(), owner);
        return owner;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
