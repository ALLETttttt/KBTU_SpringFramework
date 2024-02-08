package kz.kbtu.ConsumingREST.config;

import kz.kbtu.ConsumingREST.car.model.Engine;
import kz.kbtu.ConsumingREST.car.model.Transmission;
import kz.kbtu.ConsumingREST.person.Person;
import kz.kbtu.ConsumingREST.store.model.Item;
import kz.kbtu.ConsumingREST.store.model.Store;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    //  Constructor based DI
    @Bean
    public Item item() {
        return new Item();
    }

    //  Setter based DI
    @Bean
    public Store store() {
        Store store = new Store();
        store.setItem(item());
        return store;
    }

    @Bean
    public Engine engine() {
        return new Engine("V8", 2.4);
    }

    @Bean
    public Transmission transmission() {
        return new Transmission("sliding");
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Person personSingleton() {
        return new Person();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Person personPrototype() { return new Person(); }

}
