package kz.kbtu.EventHandling.listener;

import kz.kbtu.EventHandling.event.GenericSpringEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class GenericSpringEventListener
        implements ApplicationListener<GenericSpringEvent<String>> {
    @Override
    public void onApplicationEvent(GenericSpringEvent<String> event) {
        System.out.println("Received spring generic event - " + event.getMessage());
    }
}
