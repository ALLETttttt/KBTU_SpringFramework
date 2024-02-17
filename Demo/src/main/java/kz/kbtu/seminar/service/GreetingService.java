package kz.kbtu.seminar.service;

import kz.kbtu.seminar.model.Greeting;
import org.springframework.context.ApplicationEventPublisher;

import java.util.concurrent.atomic.AtomicLong;

public class GreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private ApplicationEventPublisher applicationEventPublisher;

    public Greeting generateGreeting(String content) {
        applicationEventPublisher.publishEvent("Greeting hello world!");
        applicationEventPublisher.publishEvent(123);
        return new Greeting(counter.incrementAndGet(), String.format(template, content));
    }
}
