package kz.kbtu.EventHandling.event;

import kz.kbtu.EventHandling.publisher.GenericSpringEventPublisher;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class GenericSpringEvent<T> extends ApplicationEvent {
    private T what;
    protected boolean success;
    private ApplicationEvent applicationEvent;

    public GenericSpringEvent(Object source, boolean message) {
        super(source);
        this.success = message;
    }

    public GenericSpringEvent(T what, boolean success, ApplicationEvent applicationEvent) {
        super(applicationEvent);
        this.what = what;
        this.success = success;
//        this.applicationEvent = applicationEvent;
    }

    public GenericSpringEvent(GenericSpringEventPublisher applicationEvent) {
        super(applicationEvent);
    }
}
