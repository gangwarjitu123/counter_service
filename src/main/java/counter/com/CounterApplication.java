package counter.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class CounterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CounterApplication.class, args);
    }
}
