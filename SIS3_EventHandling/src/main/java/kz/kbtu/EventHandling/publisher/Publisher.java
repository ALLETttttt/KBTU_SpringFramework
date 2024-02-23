package kz.kbtu.EventHandling.publisher;

import kz.kbtu.EventHandling.event.CustomSpringEvent;
import kz.kbtu.EventHandling.event.GenericSpringEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishAnnotationDrivenEvent() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        ContextStartedEvent cse = new ContextStartedEvent(applicationContext);
        applicationEventPublisher.publishEvent(cse);
    }

    public void publishContextRefreshedEvent() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        ContextRefreshedEvent cre = new ContextRefreshedEvent(applicationContext);
        applicationEventPublisher.publishEvent(cre);
    }

    public void publishCustomEvent(final String message) {
        System.out.println("Publishing custom event.");
        CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }

    public void publishGenericEvent() {
        GenericSpringEvent<String> genericSpringEvent = new GenericSpringEvent<String>(this, "hello");
        applicationEventPublisher.publishEvent(genericSpringEvent);
    }
}
