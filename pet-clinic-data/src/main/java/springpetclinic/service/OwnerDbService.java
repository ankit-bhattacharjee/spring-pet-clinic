package springpetclinic.service;

import springpetclinic.model.Owner;

public interface OwnerDbService extends DbService<Owner, Long> {
    Owner findByLastName(String lastName);
}
