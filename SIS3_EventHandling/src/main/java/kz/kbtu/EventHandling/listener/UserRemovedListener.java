package kz.kbtu.EventHandling.listener;

import kz.kbtu.EventHandling.event.UserRemovedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserRemovedListener {

    @EventListener
    void handleReturnedEvent(UserRemovedEvent event) {
        // handle ReturnedEvent ...
    }
}
