package com.ycf.model;

import lombok.Data;

//新分支修改一个文件
@Data
public class Product {
    private Integer id;
    private String name;
    private Double price;

    //这个方法是做分支切换测试的，没有意义，testMaster
    public void testMaster1() {

    }

    //这个方法是做分支切换测试的，没有意义，testMaster
    public void testMaster2() {

    }

    //这个方法是做分支切换测试的，没有意义，testMaster
    public void testMaster3() {

    }
}
