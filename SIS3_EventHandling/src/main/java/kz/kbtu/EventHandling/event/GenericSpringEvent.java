package kz.kbtu.EventHandling.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class GenericSpringEvent<T> extends ApplicationEvent {

    private T smth;
    protected String message;

    public GenericSpringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

}