package kz.project.SOAP;

import kz.project.SOAP.wsdl.NumberToDollars;
import kz.project.SOAP.wsdl.NumberToDollarsResponse;
import kz.project.SOAP.wsdl.NumberToWords;
import kz.project.SOAP.wsdl.NumberToWordsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import java.math.BigDecimal;
import java.math.BigInteger;


public class Client extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(Client.class);

    public NumberToDollarsResponse getDollars(BigDecimal number) {
        log.info("Entered number: " + number);

        NumberToDollars request = new NumberToDollars();
        request.setDNum(number);

        return (NumberToDollarsResponse)
                getWebServiceTemplate()
                        .marshalSendAndReceive(
                                "https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL",
                                request
                        );
    }

    public NumberToWordsResponse getWords(BigInteger number) {
        log.info("Entered number: " + number);

        NumberToWords request = new NumberToWords();
        request.setUbiNum(number);

        return (NumberToWordsResponse)
                getWebServiceTemplate()
                        .marshalSendAndReceive(
                                "https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL",
                                request
                        );
    }

}
