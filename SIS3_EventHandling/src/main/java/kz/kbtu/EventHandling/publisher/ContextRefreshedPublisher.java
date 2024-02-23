package kz.kbtu.EventHandling.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshedPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishContextRefreshedEvent() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        ContextRefreshedEvent cre = new ContextRefreshedEvent(applicationContext);
        applicationEventPublisher.publishEvent(cre);
    }
}
