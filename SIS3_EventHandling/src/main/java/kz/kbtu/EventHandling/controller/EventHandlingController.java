package kz.kbtu.EventHandling.controller;

import kz.kbtu.EventHandling.publisher.CustomSpringEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventHandlingController {

    private final CustomSpringEventPublisher customSpringEventPublisher;

    @GetMapping("/event")
    public void customSpringEvent() {
        String message = "event test version 0.0.1";
        customSpringEventPublisher.publishCustomEvent(message);
    }
}
