package com.application.api.Controllers;


import com.application.api.Model.Order;
import com.application.api.Model.Product;
import com.application.api.Repositories.OrderRepository;
import com.application.api.Services.OrderServices;
import com.application.api.Services.ProductServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderServices orderServices;
    private final ProductServices productServices;

    public OrderController(OrderRepository orderRepository, OrderServices orderServices, ProductServices productServices) {
        this.orderRepository = orderRepository;
        this.orderServices = orderServices;
        this.productServices = productServices;
    }

    @GetMapping({"","/all"})
    public ResponseEntity<Set<Order>> getOrders(){
        Set<Order> set = orderServices.getOrders();
        return new ResponseEntity<>(set, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrdersById(@PathVariable("id") String orderId) {
        Order order = orderServices.findByOrderNumber(Long.parseLong(orderId));
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> getProductsByOrderId(@PathVariable("id") String orderId) {
        List<Product> list = productServices.getProductsByOrderId(Long.parseLong(orderId));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/year={year}")
    public ResponseEntity<Set<Order>> getOrdersByYear(@PathVariable("year") String year){
        Set<Order> set = orderServices.getOrdersByYear(Integer.parseInt(year));
        return new ResponseEntity<>(set, HttpStatus.OK);
    }

    @GetMapping("/recent")
    public ResponseEntity<Order> getRecentOrder() {
        Order order = orderRepository.findFirst1ByOrderByOrderDateDesc();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/older")
    public ResponseEntity<Order> getOlderOrder() {
        Order order = orderRepository.findFirst1ByOrderByOrderDateAsc();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/status={status}")
    public ResponseEntity<Set<Order>> getOrdersByStatus(@PathVariable("status") String status){
        Set<Order> set = orderServices.getOrdersByStatus(status);
        return new ResponseEntity<>(set, HttpStatus.OK);
    }
}
