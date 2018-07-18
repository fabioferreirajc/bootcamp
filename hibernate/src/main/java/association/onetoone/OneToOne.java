package association.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToOne {

    public static void main(String[] args) {
        Owner owner = new Owner();
        owner.setName("Fabio");

        Car car = new Car();
        car.setMake("Nissan");
        car.setModel("juke");

        car.setOwner(owner);
        owner.setCar(car);

        Owner owner2 = new Owner();
        owner2.setName("Roger");

        Car car2 = new Car();
        car2.setModel("focus");
        car2.setMake("Ford");

        car2.setOwner(owner2);
        owner2.setCar(car2);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(owner);
        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(owner2);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("before remove " + car.getId());

        Car c = em.find(Car.class, car.getId());
        System.out.println("--------->" + c.getModel());

        c.setOwner(null);
        em.remove(c);

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
