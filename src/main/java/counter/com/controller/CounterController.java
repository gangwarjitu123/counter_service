package counter.com.controller;

import counter.com.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v0.1")
public class CounterController {
    @Autowired
    CounterService counterService;
    @PostMapping(value = "/increamentCounter")
    public Integer increamentCounter(){
        return counterService.increamentCounter();
    }
}
