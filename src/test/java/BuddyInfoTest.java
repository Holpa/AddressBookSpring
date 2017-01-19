import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ahmadholpa on 1/12/2017.
 */
public class BuddyInfoTest {
    BuddyInfo bi;
    BuddyInfo bi2;
    BuddyInfo bi3;

    @Before
    public void setUp() throws Exception {
        bi = new BuddyInfo("ahmad","4444",1);
        bi2 = new BuddyInfo();

        bi3 = new BuddyInfo();

    }


    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getName() throws Exception {
    assertEquals("ahmad",bi.getName());
    }

    @Test
    public void getphoneNumber() throws Exception {
    assertEquals("4444",bi.getphoneNumber());
    }

    @Test
    public void testDP() throws Exception
    {
        bi2.setId(2);
        bi2.setName("Tennis racket");
        bi2.setPhoneNumber("452");
        bi3.setId(3);
        bi3.setName("RatMiner you suck");



        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(bi2);
        em.persist(bi3);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT p FROM BuddyInfo p");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of Names\n----------------");

        for (BuddyInfo p : results) {

            System.out.println(p.getName() + " (id=" + p.getId() + ")");
            if(p.getId()==2) {
                assertEquals(p.getName(), "Tennis racket");
            }
        }

        // Closing connection
        em.close();

        emf.close();
    }

}