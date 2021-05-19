package com.ycf.model;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestUser implements BeanFactoryAware, BeanNameAware {

    private String name;
    private Integer age;

    private String beanFactoryClassName;
    private String beanName;


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        beanFactoryClassName = beanFactory.getClass().getName();
    }

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }
}
