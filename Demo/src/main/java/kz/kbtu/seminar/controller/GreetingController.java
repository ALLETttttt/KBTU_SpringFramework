package kz.kbtu.seminar.controller;

import kz.kbtu.seminar.model.Greeting;
import kz.kbtu.seminar.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    GreetingService greetingService = new GreetingService();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "content", defaultValue = "World!") String content) {
        return greetingService.generateGreeting(content);
    }
}
