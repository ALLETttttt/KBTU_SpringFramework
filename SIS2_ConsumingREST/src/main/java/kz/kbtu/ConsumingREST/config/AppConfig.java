package kz.kbtu.ConsumingREST.config;

import kz.kbtu.ConsumingREST.model.Item;
import kz.kbtu.ConsumingREST.model.ItemImpl;
import kz.kbtu.ConsumingREST.model.NewItem;
import kz.kbtu.ConsumingREST.model.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // Constructor based DI
    @Bean
    public ItemImpl item() {
        return new Item();
    }

    @Bean
    public ItemImpl newItem() { return new NewItem(); }

    // Setter based DI
    @Bean
    public Store store() {
        Store store = new Store();
        store.setItem1(item());
        return store;
    }
}
