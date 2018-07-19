import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.RollbackException;

public class UserService {

    EntityManagerFactory emf;


    public User1 findById(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(User1.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }


    public User1 saveOrUpdate(User1 user1) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            User1 savedUser = em.merge(user1);

            em.getTransaction().commit();

            return savedUser;

        } catch (RollbackException ex) {

            em.getTransaction().rollback();
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void save(User1 user1) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.persist(user1);
            em.getTransaction().commit();

        } catch (RollbackException ex) {

            em.getTransaction().rollback();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

}
