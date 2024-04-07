package kz.project.SOAP;

import kz.project.SOAP.wsdl.NumberToDollarsResponse;
import kz.project.SOAP.wsdl.NumberToWordsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.math.BigInteger;

@SpringBootApplication
public class SoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(Client client) {
		return args -> {
			BigDecimal _a = new BigDecimal("300");
			BigDecimal _b = new BigDecimal("400");

			NumberToDollarsResponse response = client.getDollars(_a);
			System.err.println(response.getNumberToDollarsResult());

			response = client.getDollars(_b);
			System.err.println(response.getNumberToDollarsResult());


			BigInteger _aa = new BigInteger("70");
			BigInteger _bb = new BigInteger("8000");

			NumberToWordsResponse response1 = client.getWords(_aa);
			System.err.println(response1.getNumberToWordsResult());

			response1 = client.getWords(_bb);
			System.err.println(response1.getNumberToWordsResult());

		};
	}
}
