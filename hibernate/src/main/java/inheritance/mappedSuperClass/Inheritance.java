package inheritance.mappedSuperClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Inheritance {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");

        EntityManager em = emf.createEntityManager();


        Customer customer1 = new Customer();
        customer1.setName("Fábio");
        Customer customer2 = new Customer();
        customer2.setName("Zé Carlos");

        em.getTransaction().begin();

        em.persist(customer1);
        em.persist(customer2);

        em.getTransaction().commit();


        Account account1 = new Account();
        Account account2 = new Account();

        em.getTransaction().begin();

        em.persist(account1);
        em.persist(account2);

        em.getTransaction().commit();



        em.close();

    }
}
