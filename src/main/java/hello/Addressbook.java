package hello;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmadholpa on 2/9/2017.
 * it does nothing so far
 */

@Entity
public class Addressbook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany
    private List<BuddyInfo> biL;


    public Addressbook()
    {
        biL= new ArrayList<>();
    }

    public void addBuddy(BuddyInfo bi)
    {
        biL.add(bi);
    }
    public List<BuddyInfo> getBuddyInfoList()
    {
        return this.biL;
    }

}
