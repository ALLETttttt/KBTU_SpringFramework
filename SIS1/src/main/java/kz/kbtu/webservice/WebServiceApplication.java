package kz.kbtu.webservice;

import kz.kbtu.webservice.model.Quote;

import kz.kbtu.webservice.service.QuoteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Log4j2
public class WebServiceApplication {

    QuoteService quoteService = new QuoteService();
    //Spring IoC -> Spring Inversion of Control


    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    @Bean
    @Profile("!test")
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        quoteService.init();
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "http://localhost:8081/api/random", Quote.class);
            assert quote != null;
            log.info(quote.toString());
        };
    }
}
