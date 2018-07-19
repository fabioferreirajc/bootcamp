package onetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class OnetoMany {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");

        Category category = new Category();
        category.setName("Food");

        Product product1 = new Product();
        product1.setName("Potato");

        Product product2 = new Product();
        product2.setName("Potato2");

        Product product3 = new Product();
        product3.setName("Potato2");

        Product product4 = new Product();
        product4.setName("Potato2");

        category.addProduct(product1);
        category.addProduct(product2);
        category.addProduct(product4); // will be ignored because id=null and have the same name


        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(category);
        category.addProduct(product3);
        em.getTransaction().commit();

        System.out.println(em.find(Product.class,product1.getId()).getName());

        em.close();

        emf.close();


    }
}
