package kz.kbtu.EventHandling.listener;

import kz.kbtu.EventHandling.event.UserCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedListener implements ApplicationListener<UserCreatedEvent> {

    @Async
    @Override
    public void onApplicationEvent(UserCreatedEvent event) {
        System.out.println(event.getName());
    }
}
