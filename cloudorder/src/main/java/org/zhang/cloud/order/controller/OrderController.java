package org.zhang.cloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.zhang.cloud.order.service.OrderService;
import org.zhang.mvc.v1.Response;
import org.zhang.mvc.v1.ResponseUtil;
import org.zhang.mvc.v1.util.ServiceUtil;

/**
 * @Auther: zhang
 * @Date: 2018/11/27 22:02
 * @Description:
 */

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {


    //在application类中配置，注入；
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderService orderService;

    @GetMapping("/getProduct/{id}")
    public Response queryProductById(@PathVariable String id) {
        //RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.getForObject(ServiceUtil.PRODUCT_API+"/product/list/"+id,Response.class);
        log.info(restTemplate.hashCode()+" "+String.valueOf(response));
        return ResponseUtil.success(response.getContent());
    }

    public Response createOrder(){}
}
