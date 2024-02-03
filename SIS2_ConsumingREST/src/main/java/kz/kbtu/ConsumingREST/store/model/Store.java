package kz.kbtu.ConsumingREST.store.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
public class Store {

    // Field based DI
    @Autowired
    @Qualifier("item")
    private ItemImpl item1;

    @Autowired
    @Qualifier("newItem")
    private ItemImpl item2;

    public Store() {
        item1 = new Item();
    }


    public Store(Item item1) {
        this.item1 = item1;
    }

}
