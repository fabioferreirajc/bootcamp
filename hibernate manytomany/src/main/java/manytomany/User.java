package manytomany;

import javax.persistence.*;
import javax.persistence.ManyToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;


    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER
    )
    private List<SGroup> sgroups = new LinkedList<>();

    public void addSGroup (SGroup sGroup) {
        sgroups.add(sGroup);
    }

    public List<SGroup> getSgroups() {
        return sgroups;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSgroups(List<SGroup> sgroups) {
        this.sgroups = sgroups;
    }


}
