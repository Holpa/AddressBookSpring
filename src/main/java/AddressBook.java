import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.eclipse.persistence.expressions.ExpressionOperator.Add;


/**
 * Created by ahmadholpa on 1/12/2017.
 */

@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private Integer id = null;
    @OneToMany(cascade = {CascadeType.PERSIST})
    private List<BuddyInfo> biArray;

    public AddressBook() {
        biArray = new ArrayList<BuddyInfo>();
    }

    public void addMember(BuddyInfo bi) {
        biArray.add(bi);
    }

    public void removeMemeber(int index) {
        biArray.remove(index);
    }

    public String getMember(int index) {
        return (biArray.get(index)).getName() + " phone number: " + (biArray.get(index)).getphoneNumber();
    }
    public List<BuddyInfo> getAddressBook() {
        return biArray;
    }
    public void setBiArray() {
        biArray = new ArrayList<BuddyInfo>();
    }


    public void setId(int id) {
        this.id = id;
    }






    public static void main(String args[])
    {
        AddressBook ab= new AddressBook();
        AddressBook ab1= new AddressBook();
        BuddyInfo bi1= new BuddyInfo("ahmad", "6132611947", 1);
        BuddyInfo bi2= new BuddyInfo("robert", "123456", 2);
        ab.addMember(bi1);
        ab.addMember((bi2));
        System.out.println(ab.getMember(0));

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects

        // Both buddies got presisted by using Cascade ! see Linked list
        //em.persist(bi1);
        //em.persist(bi2);
        em.persist(ab);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT p FROM BuddyInfo p");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> resultsBuddyInfo = q.getResultList();

        System.out.println("List of Names\n----------------");

        for (BuddyInfo p : resultsBuddyInfo) {

            System.out.println(p.getName() + " (id=" + p.getId() + ")" + "Phone Number: "+p.getphoneNumber());
        }
        System.out.println("Buddy info is over step 5\n");

        // Querying the contents of the database using JPQL query
        Query X = em.createQuery("SELECT p FROM AddressBook p");

        @SuppressWarnings("unchecked")
        List<AddressBook> resultsAddressBook = X.getResultList();

        System.out.println("List of Names\n----------------");

        for (AddressBook p : resultsAddressBook) {

           System.out.println( p.getMember(0) );
        }
        System.out.println("\nAddressbook with BuddyInfo  info is over step 6 \n");


        // Closing connection
        em.close();

        emf.close();
    }
}
