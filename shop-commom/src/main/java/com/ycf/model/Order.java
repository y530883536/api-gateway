package com.ycf.model;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer amount;
    private Double totalPrice;
}
