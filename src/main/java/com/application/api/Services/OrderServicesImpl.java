package com.application.api.Services;

import com.application.api.Model.Order;
import com.application.api.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OrderServicesImpl implements OrderServices {

    private final OrderRepository orderRepository;

    public OrderServicesImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Set<Order> getOrders() {
        return new HashSet<>(orderRepository.findAll());
    }

    @Override
    public Order findByOrderNumber(Long orderNumber) {
        Order order = null;
        if(orderRepository.findById(orderNumber).isPresent())
            order = orderRepository.findById(orderNumber).get();
        if(order==null)
            System.out.println("customer number not found");
        return order;
    }

    @Override
    public Set<Order> getOrdersByYear(int year) {
        Set<Order> set = new HashSet<>();
        orderRepository.findAll().forEach(order -> {
            if(order.getOrderDate().toLocalDate().getYear()==year) {
                set.add(order);
            }
        });
        return set;
    }

    @Override
    public Set<Order> getOrdersByStatus(String status) {
        return new HashSet<>(orderRepository.findAllByStatus(status));
    }
}
