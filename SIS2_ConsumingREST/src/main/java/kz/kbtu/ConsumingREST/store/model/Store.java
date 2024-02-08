package kz.kbtu.ConsumingREST.store.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
public class Store {

    // Field based DI
    @Qualifier("item")
    private Item item1;

    @Qualifier("newItem")
    private Item item2;

    public Store() { item1 = new Item(); }

    public Store(Item item) {
        this.item2 = item;
    }

}
