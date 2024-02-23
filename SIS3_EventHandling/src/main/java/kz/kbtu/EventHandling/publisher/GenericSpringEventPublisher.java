package kz.kbtu.EventHandling.publisher;


import kz.kbtu.EventHandling.event.GenericSpringEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenericSpringEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishGenericEvent() {
        GenericSpringEvent<String> genericSpringEvent = new GenericSpringEvent<>(this, true);
        applicationEventPublisher.publishEvent(genericSpringEvent);
    }

}
