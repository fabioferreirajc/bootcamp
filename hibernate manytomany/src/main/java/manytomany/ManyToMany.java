package manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ManyToMany {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");


        User user1 = new User();
        user1.setUsername("fabio");
        user1.setPassword("academia");

        User user2 = new User();
        user2.setUsername("tone");
        user2.setPassword("academia2");

        SGroup sGroup1 = new SGroup();
        sGroup1.setName("group1");

        SGroup sGroup2 = new SGroup();
        sGroup2.setName("group2");

        user1.addSGroup(sGroup1);
        user2.addSGroup(sGroup2);
        user2.addSGroup(sGroup1);

        sGroup1.addUser(user2);
        sGroup1.addUser(user1);
        sGroup2.addUser(user2);

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


        EntityManager test = emf.createEntityManager();
        test.getTransaction().begin();
        User user = test.find(User.class, 2);
        test.getTransaction().commit();
        test.close();


        List<SGroup> userGroups = user.getSgroups();
        SGroup usergroup = userGroups.get(1);
        System.out.println(usergroup.getName());

        emf.close();

    }
}
