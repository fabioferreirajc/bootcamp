import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");

        UserService userService = new UserService();
        userService.setEmf(emf);

        User user = new User();
        user.setName("fabio");
        user.setEmail("ff@mail.com");

        System.out.println("id before merge: " + user.getId());

        userService.save(user);

        System.out.println("id after merge: " + user.getId());

        System.out.println(userService.findById(1));

        user.setEmail("pp@mail.com");
        userService.saveOrUpdate(user);

        System.out.println(userService.findById(1));


        User user2 = new User ();
        user2.setName("Roger");
        user2.setEmail("rr@mail.com");

        userService.save(user2);



    }
}
