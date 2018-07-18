import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.RollbackException;

public class UserService {

    EntityManagerFactory emf;


    public User findById(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(User.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }


    public User saveOrUpdate(User user) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            User savedUser = em.merge(user);

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

    public void save(User user) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.persist(user);
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
