package kz.kbtu.ConsumingREST.car.config;

import kz.kbtu.ConsumingREST.car.model.Engine;
import kz.kbtu.ConsumingREST.car.model.Transmission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Engine engine() {
        return new Engine("V8", 2.4);
    }

    @Bean
    public Transmission transmission() {
        return new Transmission("sliding");
    }
}
