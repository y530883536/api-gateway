package com.ycf;

import com.ycf.model.TestProduct;
import com.ycf.model.TestUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        //AnnotationConfigApplicationContext要指定包名，不然它不知道去哪里扫描
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.ycf");
        /*for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        TestUser testUser = (TestUser)applicationContext.getBean("testUser");
        System.out.println(testUser);
        System.out.println(testUser.getClass());
        System.out.println(testUser.getBeanFactoryClassName());
        System.out.println(testUser.getBeanName());
        TestProduct testFactoryBean = (TestProduct)applicationContext.getBean("testFactoryBean");
        System.out.println(testFactoryBean);
        System.out.println(testFactoryBean.getClass());*/


    }

}
