package kz.kbtu.EventHandling.listener;

import kz.kbtu.EventHandling.event.UserRemovedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserRemovedListener {

    @Async
    @EventListener(condition = "#event.name eq 'reflectoring'")
    void handleReturnedEvent(UserRemovedEvent event) {
        System.out.println(event.getName());
    }
}
