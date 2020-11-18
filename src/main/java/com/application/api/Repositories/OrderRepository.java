package com.application.api.Repositories;

import com.application.api.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findFirst1ByOrderByOrderDateDesc();
    Order findFirst1ByOrderByOrderDateAsc();
    List<Order> findAllByStatus(String status);
}
