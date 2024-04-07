package kz.project.SOAP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("kz.project.SOAP.wsdl");
        return marshaller;
    }

    @Bean
    public Client countryClient(Jaxb2Marshaller marshaller) {
        Client client = new Client();
        client.setDefaultUri("https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
