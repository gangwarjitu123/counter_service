package counter.com.dao.Impl;
import counter.com.dao.CounterDao;
import counter.com.model.NumberModel;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;


@Repository
public  class CounterDaoImpl extends  BaseDaoImpl<NumberModel,Integer> implements CounterDao {



    @Override
    public    NumberModel increamentCounter( ) {
        NumberModel numberModel=null;
                numberModel = entityManager.find(NumberModel.class, 1, LockModeType.PESSIMISTIC_WRITE);
                if(numberModel!=null) {
                   numberModel.setCount(numberModel.getCount() + 1);
                   getEntityManager().merge(numberModel);


               }else{

                    numberModel = new NumberModel();
                    numberModel.setCount(1);
                    numberModel.setId(1);

                    entityManager.persist(numberModel);
                    numberModel = entityManager.find(NumberModel.class, 1);
                }

            return numberModel;

          }



}
