package kz.kbtu.EventHandling.event;

import lombok.Getter;

@Getter
public class UserRemovedEvent {
    private String name;

    public UserRemovedEvent(String name) {
        this.name = name;
    }
}
