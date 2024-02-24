package kz.kbtu.EventHandling.controller;

import kz.kbtu.EventHandling.publisher.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventHandlingController {

    private final Publisher publisher;
    private final String message = "event test version 0.0.1";

    @GetMapping("/custom")
    public void customSpringEvent() {
        publisher.publishCustomEvent(message);
    }

    @GetMapping("/annotation")
    public void annotationEvent() {
        publisher.publishAnnotationDrivenEvent();
    }

    @GetMapping("/refreshed")
    public void refreshedEvent() {
        publisher.publishContextRefreshedEvent();
    }

    @GetMapping("/generic")
    public void genericEvent() {
        publisher.publishGenericEvent();
    }

    @GetMapping("/user-event")
    public void userEvent() {
        publisher.publishUserEvent(message);
    }
}
