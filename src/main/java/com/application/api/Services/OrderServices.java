package com.application.api.Services;

import com.application.api.Model.Customer;
import com.application.api.Model.Order;

import java.util.Set;

public interface OrderServices {

    Set<Order> getOrders();
    Order findByOrderNumber(Long customerNumber);
    Set<Order> getOrdersByYear(int year);
    Set<Order> getOrdersByStatus(String status);

}
