package springpetclinic.service.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.Vet;
import springpetclinic.service.VetDbService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetDbService {

    @Override
    public Vet save(Vet vet) {
        this.save(vet.getId(), vet);
        return vet;
    }
}