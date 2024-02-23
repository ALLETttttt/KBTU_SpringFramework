package kz.kbtu.EventHandling.controller;

import kz.kbtu.EventHandling.publisher.AnnotationDrivenEventPublisher;
import kz.kbtu.EventHandling.publisher.ContextRefreshedPublisher;
import kz.kbtu.EventHandling.publisher.CustomSpringEventPublisher;
import kz.kbtu.EventHandling.publisher.GenericSpringEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventHandlingController {

    private final CustomSpringEventPublisher customSpringEventPublisher;
    private final AnnotationDrivenEventPublisher annotationDrivenEventPublisher;
    private final ContextRefreshedPublisher contextRefreshedPublisher;
    private final GenericSpringEventPublisher genericSpringEventPublisher;

    @GetMapping("/custom")
    public void customSpringEvent() {
        String message = "event test version 0.0.1";
        customSpringEventPublisher.publishCustomEvent(message);
    }

    @GetMapping("/annotation")
    public void annotationEvent() {
        annotationDrivenEventPublisher.publishAnnotationDrivenEvent();
    }

    @GetMapping("/refreshed")
    public void refreshedEvent() {
        contextRefreshedPublisher.publishContextRefreshedEvent();
    }

    @GetMapping("/generic")
    public void genericEvent() {
        genericSpringEventPublisher.publishGenericEvent();
    }
}