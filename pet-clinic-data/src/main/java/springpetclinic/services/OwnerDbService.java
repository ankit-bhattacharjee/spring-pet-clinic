package springpetclinic.services;

import springpetclinic.model.Owner;

public interface OwnerDbService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
