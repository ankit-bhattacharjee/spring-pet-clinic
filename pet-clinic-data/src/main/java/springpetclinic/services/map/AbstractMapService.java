package springpetclinic.services.map;

import springpetclinic.model.BaseEntity;
import springpetclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {
    protected Map<Long, T> map = new HashMap<>();

    public T findById(ID id) {
        return map.get(id);
    }

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
                map.put(object.getId(), object);
            }
            map.put(object.getId(), object);
        } else
            throw new RuntimeException("Object cannot be null!");
        return object;
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    protected Long getNextId() {
        return map.size() > 0 ? Collections.max(map.keySet()) + 1 : 1;
    }

}
