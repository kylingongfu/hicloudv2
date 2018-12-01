package org.zhang.cloud.order.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zhang.cloud.order.controller.OrderController;
import org.zhang.cloud.order.entity.OrderDetail;
import org.zhang.cloud.order.entity.OrderMaster;
import org.zhang.cloud.order.form.OrderForm;
import org.zhang.cloud.order.repository.OrderRepository;
import org.zhang.mvc.v1.Response;
import org.zhang.mvc.v1.util.KeyUtil;
import org.zhang.mvc.v1.util.ServiceUtil;

/**
 * @Auther: zhang
 * @Date: 2018/12/1 21:24
 * @Description:
 */

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RestTemplate restTemplate;

    public OrderForm create(OrderForm form){
        OrderMaster om = new OrderMaster();
        om.setOrderId(KeyUtil.getUUID32());
        BeanUtils.copyProperties(form,om);
        restTemplate.postForObject(ServiceUtil.PRODUCT_API,om.getOrderDetailList(),Response.class);

        for (OrderDetail od:form.getOrderDetailList()){

        }
        return null;
    }
}
