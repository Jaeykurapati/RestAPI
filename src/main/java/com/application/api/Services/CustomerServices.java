package com.application.api.Services;


import com.application.api.Model.Customer;
import com.application.api.Model.Order;

import java.util.Set;

public interface CustomerServices {

    Set<Customer> getCustomers();
    Set<Order> getCustomerOrders(Long customerNumber);
    Customer findByCustomerNumber(Long customerNumber);

}
