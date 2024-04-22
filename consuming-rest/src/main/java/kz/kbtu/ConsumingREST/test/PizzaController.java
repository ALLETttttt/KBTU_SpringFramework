package kz.kbtu.ConsumingREST.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class PizzaController {
    @Autowired
    private VegPizza vegPizza;

//    @Autowired
//    public PizzaController(VegPizza vegPizza) {
//        this.vegPizza = vegPizza;
//    }

    public String getPizza() {
        return vegPizza.getPizza();
    }
}
