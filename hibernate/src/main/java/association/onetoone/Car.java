package association.onetoone;


import javax.persistence.*;
import javax.persistence.OneToOne;


@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String make;
    private String model;

    @OneToOne
    private Owner owner; // for bidirectionality


    public Owner getOwner() {
        return owner;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getId() {
        return id;
    }
}


