package com.ycf;

import com.ycf.service.PayService;

import java.util.ServiceLoader;

public class MainApp {
    public static void main(String[] args) {
        ServiceLoader<PayService> serviceLoader = ServiceLoader.load(PayService.class);
        for (PayService payService : serviceLoader) {
            payService.pay();
        }
    }
}
