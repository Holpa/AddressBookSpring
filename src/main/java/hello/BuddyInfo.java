package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Created by ahmadholpa on 1/12/2017.
 */

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String phoneNumber;

    protected BuddyInfo() {}
    public BuddyInfo(String name, String phoneNumber) {
            this.setName(name);
            this.setPhoneNumber(phoneNumber);
    }
    public String getName()
    {
            return this.name;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return String.format(
                "buddy[id=%d, firstName='%s', phoneNumber='%s']",
                id, getName(), getPhoneNumber());
    }
}

