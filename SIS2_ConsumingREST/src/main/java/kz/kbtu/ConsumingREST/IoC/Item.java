package kz.kbtu.ConsumingREST.IoC;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Item {
    private String name;
    private Double price;

}
