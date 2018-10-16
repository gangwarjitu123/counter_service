package counter.com.dao;
import org.springframework.stereotype.Repository;
import counter.com.model.NumberModel;

@Repository
public interface CounterDao extends BaseDao<NumberModel,Integer> {
     NumberModel increamentCounter();
}
