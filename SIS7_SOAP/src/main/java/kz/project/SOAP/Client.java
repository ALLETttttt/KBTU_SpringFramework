package kz.project.SOAP;

import kz.project.SOAP.wsdl.NumberToDollars;
import kz.project.SOAP.wsdl.NumberToDollarsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.math.BigDecimal;


public class Client extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(Client.class);

    public NumberToDollarsResponse getDollars(BigDecimal number) {
        log.info("Entered number: " + number);

        NumberToDollars request = new NumberToDollars();
        request.setDNum(number);

        NumberToDollarsResponse response = (NumberToDollarsResponse)
                getWebServiceTemplate()
                        .marshalSendAndReceive(
                                "https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL",
                                request,
                                new SoapActionCallback(
                                        "https://spring.io/guides/gs-producing-web-service/GetCountryRequest")
                        );
        return response;
    }

}
