package org.zhang.cloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.zhang.cloud.order.entity.OrderDetail;
import org.zhang.cloud.order.entity.OrderMaster;
import org.zhang.cloud.order.form.OrderForm;
import org.zhang.cloud.order.service.OrderService;
import org.zhang.mvc.v1.Response;
import org.zhang.mvc.v1.ResponseUtil;
import org.zhang.mvc.v1.util.ServiceUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @GetMapping("/getDemoOrder/{id}")
    public Response getDemoOrder(@PathVariable String id) {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerAddress("长安街66号");
        orderMaster.setBuyerPhone("136616616666");
        orderMaster.setBuyerOpenid("ssxxxdd123-openid");
        orderMaster.setOrderAmount(54188.12d);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductQuantity(3);
        orderDetailList.add(orderDetail);
        orderDetail = new OrderDetail();
        orderDetail.setProductId("157875227953464068");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);
        orderMaster.setOrderDetail(orderDetailList);
        return ResponseUtil.success(orderMaster);
    }

    @PostMapping("/createOrder")
    public Response createOrder(@RequestBody OrderForm orderForm){
        OrderMaster orderMaster = orderService.create(orderForm);
        HashMap<String, String> map = new HashMap<>();
        map.put("orderId",orderMaster.getOrderId());
        return ResponseUtil.success(map);
    }
}
