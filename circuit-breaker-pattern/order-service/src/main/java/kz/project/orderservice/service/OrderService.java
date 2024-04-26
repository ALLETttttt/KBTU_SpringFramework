package kz.project.orderservice.service;

import kz.project.orderservice.model.Type;

public interface OrderService {
    Type getOrderByPostCode(String orderNumber);
}
