package kz.kbtu.EventHandling.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

//@Component
@Getter
public class UserCreatedEvent extends ApplicationEvent {
    private final String name;

    public UserCreatedEvent(Object source, String name) {
        super(source);
        this.name = name;
    }
}
