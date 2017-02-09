package hello;

import org.springframework.data.repository.CrudRepository;
/**
 * Created by ahmadholpa on 2/2/2017.
 */


public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {
    BuddyInfo findById(int id);
}