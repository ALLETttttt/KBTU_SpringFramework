package kz.kbtu.EventHandling.controller;

import kz.kbtu.EventHandling.publisher.AnnotationDrivenEventPublisher;
import kz.kbtu.EventHandling.publisher.CustomSpringEventPublisher;
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

    @GetMapping("/custom")
    public void customSpringEvent() {
        String message = "event test version 0.0.1";
        customSpringEventPublisher.publishCustomEvent(message);
    }

    @GetMapping("/annotation")
    public void annotationEvent() {
        annotationDrivenEventPublisher.publishAnnotationDrivenEvent();
    }
}
