package hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ahmadholpa on 2/2/2017.
 */

// is a controller that can be called by http://localhost:8080/buddyInfos
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {
    BuddyInfo findById(int id);
    List<BuddyInfo> findByName(String name);
}