package kz.kbtu.ConsumingREST.config;

import kz.kbtu.ConsumingREST.DI.Engine;
import kz.kbtu.ConsumingREST.DI.Transmission;
import kz.kbtu.ConsumingREST.scopes.HelloMessageGenerator;
import kz.kbtu.ConsumingREST.scopes.Person;
import kz.kbtu.ConsumingREST.IoC.Item;
import kz.kbtu.ConsumingREST.IoC.Store;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

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
    public Person personPrototype() { return new Person();}

    @Bean
    @RequestScope
    public HelloMessageGenerator requestScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @SessionScope
    public HelloMessageGenerator sessionScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @ApplicationScope
    public HelloMessageGenerator applicationScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HelloMessageGenerator websocketScopedBean() {
        return new HelloMessageGenerator();
    }

}
