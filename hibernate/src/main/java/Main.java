import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");

        UserService userService = new UserService();
        userService.setEmf(emf);

        User1 user1 = new User1();
        user1.setName("fabio");
        user1.setEmail("ff@mail.com");

        System.out.println("id before merge: " + user1.getId());

        userService.save(user1);

        System.out.println("id after merge: " + user1.getId());

        System.out.println(userService.findById(1));

        user1.setEmail("pp@mail.com");
        userService.saveOrUpdate(user1);

        System.out.println(userService.findById(1));


        User1 user12 = new User1();
        user12.setName("Roger");
        user12.setEmail("rr@mail.com");

        userService.save(user12);



    }
}
