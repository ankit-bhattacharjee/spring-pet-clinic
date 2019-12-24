package springpetclinic.services.jpa;

import org.springframework.data.repository.CrudRepository;
import springpetclinic.model.BaseEntity;
import springpetclinic.services.CrudService;

import java.util.Set;

public abstract class AbstractJpaService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

    protected final CrudRepository<T, ID> repository;

    protected AbstractJpaService(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Set<T> findAll() {
        return (Set<T>) repository.findAll();
    }

    @Override
    public T save(T object) {
        return repository.save(object);
    }

    @Override
    public void delete(T object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
