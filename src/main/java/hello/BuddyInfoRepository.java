package hello;

import org.springframework.data.repository.CrudRepository;
/**
 * Created by ahmadholpa on 2/2/2017.
 */

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "buddy", path = "buddy")
public interface BuddyInfoRepository extends PagingAndSortingRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(@Param("name") String name);
}