package kz.kbtu.ConsumingREST.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public PizzaController pizzaController() {
        return new PizzaController();
    }

    @Bean
    public VegPizza vegPizza() {
        return new VegPizza();
    }
}
