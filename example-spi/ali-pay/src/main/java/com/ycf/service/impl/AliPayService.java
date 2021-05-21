package com.ycf.service.impl;

import com.ycf.service.PayService;

public class AliPayService implements PayService {

    @Override
    public void pay() {
        System.out.println("aliPay");
    }
}
