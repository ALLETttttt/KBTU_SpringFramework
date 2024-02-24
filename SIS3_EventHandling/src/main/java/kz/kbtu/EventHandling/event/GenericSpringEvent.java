package kz.kbtu.EventHandling.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class GenericSpringEvent<T> extends ApplicationEvent {

    private T something;
    protected String message;

    public GenericSpringEvent(Object source, T something, String message) {
        super(source);
        this.something = something;
        this.message = message;
    }

}