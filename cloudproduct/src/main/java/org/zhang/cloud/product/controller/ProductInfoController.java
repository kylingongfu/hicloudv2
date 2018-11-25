package org.zhang.cloud.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhang.cloud.product.entity.ProductInfo;
import org.zhang.cloud.product.repository.ProductInfoRepository;

@RestController
@RequestMapping("/product")
public class ProductInfoController {
    @Autowired
    ProductInfoRepository repository;

    /*@Autowired
    SimpleJpaRepository<ProductInfo,String> sir;*/


    @GetMapping("/listAll")
    public Iterable<ProductInfo> listAll(){
        return repository.findAll();
    }
}
