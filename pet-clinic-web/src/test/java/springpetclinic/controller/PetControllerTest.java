package springpetclinic.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import springpetclinic.model.Owner;
import springpetclinic.model.Pet;
import springpetclinic.model.PetType;
import springpetclinic.services.OwnerService;
import springpetclinic.services.PetService;
import springpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class PetControllerTest {
    @Mock
    private PetService petService;
    @Mock
    private PetTypeService petTypeService;
    @Mock
    private OwnerService ownerService;
    @InjectMocks
    private PetController petController;
    private MockMvc mockMvc;
    private Owner owner;
    private Set<PetType> petTypes;

    @BeforeEach
    public void setUp() {
        owner = Owner.builder().id(1L).build();
        Set<PetType> petTypes = new HashSet<>();
        petTypes.add(PetType.builder().id(1L).name("Cat").build());
        petTypes.add(PetType.builder().id(2L).name("Dog").build());
        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
    }

    @Test
    void initCreationForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(get("/owners/1/pets/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));
    }

    @Test
    void processCreationForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(post("/owners/1/pets/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(petService).save(any());
    }

    @Test
    void initUpdateForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);
        when(petService.findById(anyLong())).thenReturn(Pet.builder().id(2L).build());

        mockMvc.perform(get("/owners/1/pets/2/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));
    }

    @Test
    void processUpdateForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(post("/owners/1/pets/2/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(petService).save(any());
    }

    @Test
    void populatePetTypes() {
        //todo impl
    }

    @Test
    void findOwner() {
        //todo impl
    }

    @Test
    void initOwnerBinder() {
        //todo impl
    }

}
