package manytomany;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ManyToMany {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");


        User user1 = new User();
        user1.setUsername("fabio");
        user1.setPassword("academia");

        User user2 = new User();
        user2.setUsername("tone");
        user2.setPassword("academia2");

        User user3 = new User();
        user3.setUsername("tonecas");
        user3.setPassword("academia3");


        SGroup sGroup1 = new SGroup();
        sGroup1.setName("barbarian");

        SGroup sGroup2 = new SGroup();
        sGroup2.setName("grupo2 coistio");

        user1.addSGroup(sGroup1);
        user2.addSGroup(sGroup2);
        user2.addSGroup(sGroup1);
        user3.addSGroup(sGroup2);

        sGroup1.addUser(user2);
        sGroup1.addUser(user1);
        sGroup2.addUser(user2);
        sGroup2.addUser(user3);

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(user1);
        em.getTransaction().commit();
        em.close();


        EntityManager em1 = emf.createEntityManager();

        em1.getTransaction().begin();

        User savedUser = em1.merge(user2);

        em1.getTransaction().commit();
        em1.close();


        EntityManager em2 = emf.createEntityManager();

        em2.getTransaction().begin();

        User savedUser1 = em2.merge(user3); //////////////

        em2.getTransaction().commit();
        em2.close();

        emf.close();

        System.out.println(user2.getSgroups());
        System.out.println(sGroup2.getUsers());
    }
}
