package kz.kbtu.ConsumingREST.store.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Item {
    private String name;
    private Double price;

}
