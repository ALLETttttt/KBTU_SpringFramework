package kz.project.SoapWebService;

import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import kz.project.SoapWebService.country.CountryClient;
import kz.project.SoapWebService.number.NumberClient;
import kz.project.SoapWebService.wsdl.NumberToDollarsResponse;
import kz.project.SoapWebService.wsdl.NumberToWordsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.math.BigInteger;

@SpringBootApplication
public class SoapWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapWebServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner lookup(CountryClient countryClient, NumberClient numberClient) {
		return args -> {
			String country = "Spain";

			if (args.length > 0) {
				country = args[0];
			}
			GetCountryResponse response = countryClient.getCountry(country);
			System.err.println(response.getCountry().getCurrency());

			BigDecimal num = new BigDecimal("4000");
			NumberToDollarsResponse response1 = numberClient.getDollar(num);
			System.err.println(response1.getNumberToDollarsResult());

			BigInteger number = new BigInteger("300000");
			NumberToWordsResponse response2 = numberClient.getWord(number);
			System.err.println(response2.getNumberToWordsResult());

		};
	}
}
