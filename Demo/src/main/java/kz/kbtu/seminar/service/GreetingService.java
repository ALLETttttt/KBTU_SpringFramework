package kz.kbtu.seminar.service;

import kz.kbtu.seminar.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

public class GreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public Greeting generateGreeting(String content) {
        return new Greeting(counter.incrementAndGet(), String.format(template, content));
    }
}
