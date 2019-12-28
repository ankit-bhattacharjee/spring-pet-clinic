package springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springpetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;
    private final Long id = 1L;
    private final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(id).lastName(lastName).build());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(id);
        assertEquals(id, owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> results = ownerMapService.findAll();
        assertEquals(id, results.size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner = ownerMapService.save(Owner.builder().id(id).build());
        assertEquals(2L, owner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = ownerMapService.save(Owner.builder().build());
        assertNotNull(owner);
        assertNotNull(owner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(id));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(id);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByExistingLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(id, owner.getId());

    }

    @Test
    void findByNoExistingLastName() {
        Owner owner = ownerMapService.findByLastName("foo");
        assertNull(owner);
    }


}