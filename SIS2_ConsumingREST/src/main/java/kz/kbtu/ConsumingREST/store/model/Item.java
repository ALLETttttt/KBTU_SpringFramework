package kz.kbtu.ConsumingREST.store.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("item")
public class Item implements ItemImpl {
    private String name;
    private Double price;

    @Override
    public void getItem() {
        System.out.println("This is Item!!");
    }
}
