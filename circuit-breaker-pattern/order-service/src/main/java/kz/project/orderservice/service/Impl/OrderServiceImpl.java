package kz.project.orderservice.service.Impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import kz.project.orderservice.dto.AddressDto;
import kz.project.orderservice.model.Failure;
import kz.project.orderservice.model.Order;
import kz.project.orderservice.model.Type;
import kz.project.orderservice.repository.OrderRepository;
import kz.project.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVICE_NAME = "order-service";

    private static final String ADDRESS_SERVICE_URL = "http://localhost:9090/addresses/";

    @CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "fallbackMethod")
    public Type getOrderByPostCode(String orderNumber) {
        Order order = orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new RuntimeException("Order Not Found: " + orderNumber));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AddressDto> entity = new HttpEntity<>(null, headers);
        ResponseEntity<AddressDto> response = restTemplate.exchange(
                (ADDRESS_SERVICE_URL + order.getPostalCode()), HttpMethod.GET, entity,
                AddressDto.class);
        AddressDto addressDTO = response.getBody();
        if (addressDTO != null) {
            order.setShippingState(addressDTO.getState());
            order.setShippingCity(addressDTO.getCity());
        }
        return order;
    }

    private Type fallbackMethod(Exception e) {
        return new Failure("Address service is not responding properly");
    }
}
