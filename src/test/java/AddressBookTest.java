import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ahmadholpa on 1/12/2017.
 */
public class AddressBookTest {
    BuddyInfo bi;
    AddressBook ab;
    @Before
    public void setUp() throws Exception {
    ab = new AddressBook();
    bi = new BuddyInfo("ahmad", "4444",1);
    ab.addMember(bi);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addMember() throws Exception {
        ab.addMember(bi);
        assertEquals(2,ab.getAddressBook().size());
    }

    @Test
    public void removeMemeber() throws Exception {
        ab.removeMemeber(0);
        assertEquals(0,ab.getAddressBook().size());
    }

    @Test
    public void getMember() throws Exception {
        assertEquals(ab.getMember(0),ab.getMember(0));
    }

}