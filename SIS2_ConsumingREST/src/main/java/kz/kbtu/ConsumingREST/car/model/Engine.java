package kz.kbtu.ConsumingREST.car.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Engine {
    private String version;
    private Double volume;
}
