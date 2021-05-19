package com.ycf.service;

import com.ycf.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-product")
public interface ProductService {

    @RequestMapping("/product/getById/{id}")
    Product getProductById(@PathVariable Integer id);
}
