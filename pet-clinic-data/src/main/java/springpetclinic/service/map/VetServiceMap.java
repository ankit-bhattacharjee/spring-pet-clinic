package springpetclinic.service.map;

import springpetclinic.model.Vet;

public class VetServiceMap extends AbstractMapService<Vet, Long> {

    @Override
    public Vet save(Vet vet) {
        this.save(vet.getId(), vet);
        return vet;
    }
}
