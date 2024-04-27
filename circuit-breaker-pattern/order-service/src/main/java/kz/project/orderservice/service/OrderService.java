package kz.project.orderservice.service;

import kz.project.orderservice.model.Order;
import kz.project.orderservice.model.Type;

import java.util.List;

public interface OrderService {
    Type getOrderByPostCode(String orderNumber);

    List<Order> getAllOrders();
}
