package kz.project.SOAP;

import kz.project.SOAP.wsdl.NumberToDollarsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class SoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(Client client) {
		return args -> {
			BigDecimal _a = new BigDecimal("0.03");
			BigDecimal _b = new BigDecimal("0.04");

			NumberToDollarsResponse response = client.getDollars(_a);
			System.err.println(response.getNumberToDollarsResult());

			response = client.getDollars(_b);
			System.err.println(response.getNumberToDollarsResult());
		};
	}
}
