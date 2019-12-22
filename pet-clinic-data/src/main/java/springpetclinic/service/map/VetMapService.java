package springpetclinic.service.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.Specialty;
import springpetclinic.model.Vet;
import springpetclinic.service.SpecialtyService;
import springpetclinic.service.VetDbService;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetDbService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }
}
