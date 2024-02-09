package kz.kbtu.ConsumingREST.DI;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Engine {
    private String version;
    private Double volume;
}
