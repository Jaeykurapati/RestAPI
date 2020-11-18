package com.application.api.Repositories;

import com.application.api.Model.Order;
import com.application.api.Model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {

    List<OrderDetails> findAllByOrderNumberEquals(Long orderNumber);
    List<OrderDetails> findAllByOrderNumber(Long orderNumber);
    List<OrderDetails> findAllOrderDetailsByOrderNumber(Long orderId);
}
