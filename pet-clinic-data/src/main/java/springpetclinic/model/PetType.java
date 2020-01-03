package springpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Types")
public class PetType extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return name;
    }

    @Builder
    public PetType petType(Long id, String name) {
        super(id);
        this.name = name;
    }
}
