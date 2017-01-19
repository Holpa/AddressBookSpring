import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ahmadholpa on 1/12/2017.
 */

@Entity
public class BuddyInfo {
    private String name;
    private String phoneNumber;

    @Id
    private Integer id = null;

    public void setId(Integer id)
    {
        this.id = id;
    }
    public BuddyInfo()
    {

    }
        public BuddyInfo(String name, String phoneNumber, int id)
        {
            this.name= name;
            this.phoneNumber = phoneNumber;
            this.id= id;
        }

        public String getName()
        {
            return this.name;
        }
        public String getphoneNumber()
        {
            return this.phoneNumber;
        }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

