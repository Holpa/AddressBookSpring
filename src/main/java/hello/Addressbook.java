package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmadholpa on 2/9/2017.
 */
@Entity
public class Addressbook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;


    public Addressbook()
    {

    }


}
