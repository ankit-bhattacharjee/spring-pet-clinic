package springpetclinic.service;

import java.util.Set;

public interface CrudService<T, ID> {
    T findById(ID id);

    Set<T> findAll();

    T save(T owner);

    void delete(T object);

    void deleteById(ID id);


}
