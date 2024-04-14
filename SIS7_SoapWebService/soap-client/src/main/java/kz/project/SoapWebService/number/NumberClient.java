package kz.project.SoapWebService.number;


import kz.project.SoapWebService.wsdl.NumberToDollars;
import kz.project.SoapWebService.wsdl.NumberToDollarsResponse;
import kz.project.SoapWebService.wsdl.NumberToWords;
import kz.project.SoapWebService.wsdl.NumberToWordsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(NumberClient.class);

    public NumberToDollarsResponse getDollar(BigDecimal dNum) {

        NumberToDollars request = new NumberToDollars();
        request.setDNum(dNum);

        log.info("Requesting location for " + dNum);

        NumberToDollarsResponse response = (NumberToDollarsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL",
                        request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

        return response;
    }


    public NumberToWordsResponse getWord(BigInteger ubiNum) {

        NumberToWords request = new NumberToWords();
        request.setUbiNum(ubiNum);

        log.info("Requesting location for " + ubiNum);

        NumberToWordsResponse response = (NumberToWordsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL",
                        request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

        return response;
    }

}