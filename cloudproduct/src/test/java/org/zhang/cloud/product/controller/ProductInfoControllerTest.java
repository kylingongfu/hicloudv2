package org.zhang.cloud.product.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhang.cloud.product.entity.ProductInfo;
import org.zhang.cloud.product.service.ProductService;
import org.zhang.mvc.v1.ResponseUtil;

import java.util.ArrayList;

// 获取启动类，加载配置，确定装载 Spring 程序的装载方法，它回去寻找 主配置启动类（被 @SpringBootApplication 注解的）
@SpringBootTest

// 让 JUnit 运行 Spring 的测试环境， 获得 Spring 环境的上下文的支持
@RunWith(SpringRunner.class)
public class ProductInfoControllerTest {


    @Autowired
    private ProductService productService;

    @Test
    public void decreaseStock() {
        ArrayList<ProductInfo> productInfos = new ArrayList<>();
        ProductInfo pi = new ProductInfo();
        pi.setProductId("157875227953464068");
        pi.setProductStock(2);
        productInfos.add(pi);

        pi = new ProductInfo();
        pi.setProductId("164103465734242707");
        pi.setProductStock(3);
        productInfos.add(pi);

        pi = new ProductInfo();
        pi.setProductId("157875196366160022");
        pi.setProductStock(100);
        productInfos.add(pi);

        ArrayList<ProductInfo> productInfos1 = productService.decreaseStock(productInfos);
        System.out.println(ResponseUtil.success(productInfos1));
    }
}