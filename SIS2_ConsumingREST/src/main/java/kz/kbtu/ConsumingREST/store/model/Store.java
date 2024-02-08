package kz.kbtu.ConsumingREST.store.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
public class Store {

    // Field based DI
    @Autowired
    private Item item;


    public Store() { item = new Item(); }

    public Store(Item item) {
        this.item = item;
    }

}
