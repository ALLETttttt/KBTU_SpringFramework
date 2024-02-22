package kz.kbtu.EventHandling.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class AnnotationDrivenEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishAnnotationDrivenEvent() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        ContextStartedEvent cse = new ContextStartedEvent(applicationContext);
        applicationEventPublisher.publishEvent(cse);
    }
}
