package hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ahmadholpa on 2/2/2017.
 */

// is a controller that can be called by http://localhost:8080/buddyInfos
public interface TicTacToeRepository extends CrudRepository<TicTacToe, Integer> {
    TicTacToe findById(int id);
    List<TicTacToe> findByName(String name);
}