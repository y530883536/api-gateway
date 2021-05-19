package com.ycf.controller;

import com.ycf.model.Product;
import com.ycf.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/getById/{id}")
    public Product getById(@PathVariable Integer id){
        Product product = new Product();
        product.setId(1);
        product.setProductName("phone");
        product.setPrice(1000D);
        return product;
    }

}
