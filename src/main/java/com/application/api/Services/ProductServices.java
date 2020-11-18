package com.application.api.Services;

import com.application.api.Model.Product;

import java.util.List;
import java.util.Set;

public interface ProductServices {

    Set<Product> getProducts();
    List<Product> getProductsByOrderId(Long orderId);
}
