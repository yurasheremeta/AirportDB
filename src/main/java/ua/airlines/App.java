package ua.airlines;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("logos");
        EntityManager em = factory.createEntityManager();
        
        em.close();
        factory.close();
    }
}
