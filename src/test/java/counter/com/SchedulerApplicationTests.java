package counter.com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import counter.com.service.CounterService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class    SchedulerApplicationTests {

    @Autowired
    CounterService counterService;


    @Test
    public void contextLoads() {
    }

    @Test
    public void TestApiLoadTesting(){
        customThread customThread= new customThread(counterService);
        for(int i=0; i<10; i++){
           new Thread(customThread).start();
        }

    }


}

class customThread implements  Runnable{
    CounterService counterService;
    customThread(CounterService counterService)
    {
        this.counterService=counterService;
    }
    @Override
    public void run() {

        counterService.increamentCounter();
    }
}
