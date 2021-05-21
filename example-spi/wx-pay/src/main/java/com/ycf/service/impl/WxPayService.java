package com.ycf.service.impl;

import com.ycf.service.PayService;

public class WxPayService implements PayService {

    @Override
    public void pay() {
        System.out.println("wxPay");
    }
}
