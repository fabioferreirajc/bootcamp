package manytomany;

import javax.persistence.*;
import javax.persistence.ManyToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "sgroup")
public class SGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    @ManyToMany(
            mappedBy = "sgroups",
            fetch = FetchType.EAGER
    )
    private List<User> users = new LinkedList<>();

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    @Override
    public String toString() {
        return this.getName();
    }
}
