import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();


        //System.out.println("Result: " +
        //        em.createNativeQuery("select 1 + 1").getSingleResult());


        User user = new User();

        em.getTransaction().begin();

        em.persist(user);
        user.setName("fabio");
        user.setEmail("ff@mail.com");

        em.getTransaction().commit();



        em.close();

        emf.close();
    }
}
