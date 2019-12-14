package springpetclinic.service;

import java.util.Set;

public interface DbService<T, U> {
    T findById(U id);

    T save(T owner);

    Set<T> findAll();

}
