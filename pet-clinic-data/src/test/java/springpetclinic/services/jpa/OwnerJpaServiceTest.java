package springpetclinic.services.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springpetclinic.model.Owner;
import springpetclinic.repositories.OwnerRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @Mock
    private OwnerRepository ownerRepository;
    @InjectMocks
    private OwnerJpaService ownerJpaService;
    private Owner owner;
    private static final Long id = 1L;
    private static final String LAST_NAME = "Smith";

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(id).lastName("Smith").build();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));
        Owner owner = ownerJpaService.findById(id);
        assertNotNull(owner);
        assertEquals(id, owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(owner);
        owners.add(Owner.builder().id(2L).lastName("foo").build());
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> results = ownerJpaService.findAll();
        assertNotNull(results);
        assertEquals(2, results.size());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner owner = ownerJpaService.save(Owner.builder().build());
        assertNotNull(owner);
    }

    @Test
    void delete() {
        ownerJpaService.delete(owner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerJpaService.deleteById(id);
        verify(ownerRepository).deleteById(any());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner owner = ownerJpaService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}