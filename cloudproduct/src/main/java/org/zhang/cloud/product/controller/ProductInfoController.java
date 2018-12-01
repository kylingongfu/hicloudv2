package org.zhang.cloud.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zhang.cloud.product.ProductService;
import org.zhang.cloud.product.entity.ProductInfo;
import org.zhang.mvc.v1.Response;
import org.zhang.mvc.v1.ResponseUtil;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductInfoController {

    @Autowired
    ProductService productService;

    /*@Autowired
    SimpleJpaRepository<ProductInfo,String> sir;*/

    @PostMapping("/decreaseStock")
    public Response decreaseStock(List<ProductInfo> piList){
        productService.decreaseStock(piList);
        return null;
    }


    @GetMapping("/listAll")
    public Iterable<ProductInfo> listAll(){
        return productService.findAll();
    }

    @RequestMapping("/list/{id}")
    public Response queryProductInfoById(@PathVariable String id){
        System.out.println(id);
        return ResponseUtil.success(productService.findById(id));
    }

    @RequestMapping("/listByStatus/{status}")
    public Response listByStatus(@PathVariable int status){

        return ResponseUtil.success(productService.findByStatus(status));
    }

}
