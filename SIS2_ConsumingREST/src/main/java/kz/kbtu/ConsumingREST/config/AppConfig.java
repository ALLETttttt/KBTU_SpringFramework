package kz.kbtu.ConsumingREST.config;

import kz.kbtu.ConsumingREST.model.Item;
import kz.kbtu.ConsumingREST.model.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // Constructor based DI
    @Bean
    public Item item() {
        return new Item();
    }

    @Bean
    public Store store() {
        return new Store(item());
    }

}
