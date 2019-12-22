package springpetclinic.service.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.Vet;
import springpetclinic.service.VetDbService;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetDbService {

}
