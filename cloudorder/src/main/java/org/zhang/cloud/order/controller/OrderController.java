package org.zhang.cloud.order.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.zhang.mvc.v1.Response;
import org.zhang.mvc.v1.ResponseUtil;

/**
 * @Auther: zhang
 * @Date: 2018/11/27 22:02
 * @Description:
 */

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    private final static String PRODUCT_API = "http://PRODUCT";

    //在application类中配置，注入；
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getProduct/{id}")
    public Response queryProductById(@PathVariable String id) {
        //RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.getForObject(PRODUCT_API+"/product/list/"+id,Response.class);
        log.info(String.valueOf(response));
        return ResponseUtil.success(response.getContent());
    }
}
