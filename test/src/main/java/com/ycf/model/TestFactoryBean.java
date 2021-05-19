package com.ycf.model;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class TestFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        TestProduct product = new TestProduct();
        return product;
    }

    @Override
    public Class<?> getObjectType() {
        return TestProduct.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
