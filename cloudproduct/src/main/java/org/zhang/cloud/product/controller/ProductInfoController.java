package org.zhang.cloud.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhang.cloud.product.ProductService;
import org.zhang.cloud.product.entity.ProductInfo;
import org.zhang.mvc.v1.Response;
import org.zhang.mvc.v1.ResponseUtil;

@RestController
@RequestMapping("/product")
public class ProductInfoController {

    @Autowired
    ProductService service;

    /*@Autowired
    SimpleJpaRepository<ProductInfo,String> sir;*/


    @GetMapping("/listAll")
    public Iterable<ProductInfo> listAll(){
        return service.findAll();
    }

    @RequestMapping("/list/{id}")
    public Response queryProductInfoById(@PathVariable String id){

        return ResponseUtil.success(service.findById(id));
    }
}
