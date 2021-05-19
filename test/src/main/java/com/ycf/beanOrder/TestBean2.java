package com.ycf.beanOrder;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class TestBean2 implements BeanPostProcessor, InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("======" + this.getClass() + "afterPropertiesSet======");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("======" + bean.getClass() + "===" + this.getClass() + "===" + "postProcessAfterInitialization======");
        return bean;
    }
}
