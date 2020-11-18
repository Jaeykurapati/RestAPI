package com.application.api.Services;

import com.application.api.Model.OrderDetails;
import com.application.api.Model.Product;
import com.application.api.Repositories.OrderDetailsRepository;
import com.application.api.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class ProductServicesImpl implements ProductServices{

    private final ProductRepository productRepository;
    private final OrderDetailsRepository orderDetailsRepository;

    public ProductServicesImpl(ProductRepository productRepository, OrderDetailsRepository orderDetailsRepository) {
        this.productRepository = productRepository;
        this.orderDetailsRepository = orderDetailsRepository;
    }


    @Override
    public Set<Product> getProducts() {
        return new HashSet<>(productRepository.findAll());
    }

    @Override
    public List<Product> getProductsByOrderId(Long orderId) {

        List<String> productCodes = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<OrderDetails> orderDetails = new ArrayList<>(orderDetailsRepository.findAll());
        for(OrderDetails order:orderDetails){
            if(order.getOrderNumber().equals(orderId)) {
                productCodes.add(order.getProductCode());
            }
        }
        for(String str:productCodes){
            products.add(productRepository.findByProductCode(str));
        }
        return products;
    }
}
