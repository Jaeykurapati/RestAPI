package com.application.api.Controllers;

import com.application.api.Model.Product;
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
@RequestMapping("products")
public class ProductController {

    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }


    @GetMapping({"/all",""})
    public ResponseEntity<Set<Product>> getOrders(){
        Set<Product> set = productServices.getProducts();
        return new ResponseEntity<>(set, HttpStatus.OK);
    }

    @GetMapping("/orderId={orderId}")
    public ResponseEntity<List<Product>> getProductsByOrderId(@PathVariable("orderId") String orderId){
        List<Product> set = productServices.getProductsByOrderId(Long.parseLong(orderId));
        return new ResponseEntity<>(set, HttpStatus.OK);
    }
}
