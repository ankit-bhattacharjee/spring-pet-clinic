package springpetclinic.service.map;

import springpetclinic.model.Owner;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> {

    @Override
    public Owner save(Owner owner) {
        this.save(owner.getId(), owner);
        return owner;
    }
}
