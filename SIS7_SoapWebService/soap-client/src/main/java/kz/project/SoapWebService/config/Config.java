package kz.project.SoapWebService.config;

import kz.project.SoapWebService.country.CountryClient;
import kz.project.SoapWebService.number.NumberClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config {

    @Bean
    public Jaxb2Marshaller countryMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("io.spring.guides.gs_producing_web_service");
//        marshaller.setContextPath("kz.project.SoapWebService.wsdl");
        return marshaller;
    }

    @Bean
    public CountryClient countryClient(Jaxb2Marshaller countryMarshaller) {
        CountryClient client = new CountryClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(countryMarshaller);
        client.setUnmarshaller(countryMarshaller);
        return client;
    }

    @Bean
    public Jaxb2Marshaller numberMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("kz.project.SoapWebService.wsdl");
        return marshaller;
    }

    @Bean
    public NumberClient numberClient(Jaxb2Marshaller numberMarshaller) {
        NumberClient client = new NumberClient();
        client.setDefaultUri("https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL");
        client.setMarshaller(numberMarshaller);
        client.setUnmarshaller(numberMarshaller);
        return client;
    }
}
