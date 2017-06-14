package repo;

import model.Mission;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by yb
 * on 6/12/17.
 */
public interface MissionRepository extends MongoRepository<Mission, String> {
}
