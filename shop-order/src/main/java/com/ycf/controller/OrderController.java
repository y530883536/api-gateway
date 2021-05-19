package com.ycf.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ycf.model.Order;
import com.ycf.model.Product;
import com.ycf.model.User;
import com.ycf.service.ProductService;
import com.ycf.service.UserService;
import com.ycf.utils.RedisUtils;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/getById/{id}")
    @SentinelResource("orderById")
    public Order getById(@PathVariable Integer id) throws Exception{
        //Product product = productService.getProductById(id);
        //System.out.println(product.getName());
        User user = userService.getUserById(id);
        Order order = new Order();
        order.setId(1);
        order.setProductId(1);
        order.setUserId(user.getId());
        order.setAmount(3);
        order.setTotalPrice(3000D);
        return order;
    }

}
