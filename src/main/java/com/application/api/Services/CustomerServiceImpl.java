package com.application.api.Services;

import com.application.api.Model.Customer;
import com.application.api.Model.Order;
import com.application.api.Repositories.CustomerRepository;
import com.application.api.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerServices{

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public Set<Customer> getCustomers() {
        Set<Customer> set = new HashSet<>();
        customerRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Customer findByCustomerNumber(Long customerNumber) {
        Customer customer = customerRepository.findById(customerNumber).get();
        if(customer==null)
            System.out.println("customer number not found");
        return customer;
    }

    @Override
    public Set<Order> getCustomerOrders(Long customerNumber) {
        Set<Order> set = new HashSet<>();
        orderRepository.findAll()
                        .forEach(order -> {
                            if(order.getCustomerNumber().equals(customerNumber)) {
                                set.add(order);
                            }
                        });

        return set;
    }
}
