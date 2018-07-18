package association.onetoone;

import javax.persistence.*;
import javax.persistence.OneToOne;

@Entity
@Table(name = "owner")

public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToOne(
            // propagate changes on category entity to product entities
            cascade = {CascadeType.ALL},
            // make sure to remove cars if unlinked from owners
            orphanRemoval = true,
            // mappedBy is required for bidirectional associations, and it tells hibernate
            // to use the user foreign key on the Car table to define the Owner
            mappedBy = "owner"
    )
    private Car car;

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
