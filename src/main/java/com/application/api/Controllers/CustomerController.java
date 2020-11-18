package com.application.api.Controllers;

import com.application.api.Model.Customer;
import com.application.api.Model.Order;
import com.application.api.Repositories.CustomerRepository;
import com.application.api.Repositories.OrderRepository;
import com.application.api.Services.CustomerServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("customers")
public class CustomerController {

    private final CustomerServices customerServices;

    public CustomerController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    @GetMapping({"/all",""})
    public ResponseEntity<Set<Customer>> getCustomers(){
        Set<Customer> set = customerServices.getCustomers();
        return new ResponseEntity<>(set, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String customerId) {
        Customer customer = customerServices.findByCustomerNumber(Long.parseLong(customerId));
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<Set<Order>> getCustomerOrdersById(@PathVariable("id") String customerId) {
        Set<Order> set = customerServices.getCustomerOrders(Long.parseLong(customerId));
        return new ResponseEntity<>(set,HttpStatus.OK);
    }
}
