package counter.com.service.Impl;
import counter.com.dao.CounterDao;
import counter.com.model.NumberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import counter.com.service.CounterService;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




@Service
public class CounterServiceImpl implements CounterService {

    @Autowired
    private CounterDao counterDao;
    @Autowired
    private PlatformTransactionManager transactionManager;



    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
      public synchronized Integer increamentCounter() {
        NumberModel numberModel=counterDao.increamentCounter();

         return numberModel.getCount();

        }
    }

