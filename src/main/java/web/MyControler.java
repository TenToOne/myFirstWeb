package web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyControler {
    @RequestMapping(value = "/hello")
    public String helloWorld() {
        return "Hello!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    }
}