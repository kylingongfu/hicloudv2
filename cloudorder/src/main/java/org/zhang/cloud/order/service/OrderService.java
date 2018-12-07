package org.zhang.cloud.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zhang.cloud.order.controller.OrderController;
import org.zhang.cloud.order.entity.OrderDetail;
import org.zhang.cloud.order.entity.OrderMaster;
import org.zhang.cloud.order.form.OrderForm;
import org.zhang.cloud.order.form.ProductInfoForm;
import org.zhang.cloud.order.repository.OrderDetailRepository;
import org.zhang.cloud.order.repository.OrderRepository;
import org.zhang.mvc.v1.Response;
import org.zhang.mvc.v1.util.KeyUtil;
import org.zhang.mvc.v1.util.ServiceUtil;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhang
 * @Date: 2018/12/1 21:24
 * @Description:
 */
@Slf4j
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    RestTemplate restTemplate;

    @Transactional
    public OrderMaster create(OrderForm form) {
        OrderMaster om = new OrderMaster();
        BeanUtils.copyProperties(form, om);
        om.setOrderId(KeyUtil.getUUID32());
        om.setOrderDetail(new ArrayList<OrderDetail>());
        om = orderRepository.save(om);
        List<OrderDetail> detailList = new ArrayList<OrderDetail>();
        Response response;

        for (OrderDetail od : form.getOrderDetail()) {
            response = restTemplate.postForObject(ServiceUtil.PRODUCT_API + "/product/list/" + od.getProductId(), null, Response.class);
            //Student user= gson.fromJson(jsonStr, User.class);
            log.info("get from api " + response);
            ProductInfoForm pio = response.getContentType(ProductInfoForm.class);
            System.out.println(pio);
            System.out.println(od);
            od.setOrderMaster(om);
            od.setProductId(pio.getProductId());
            od.setProductName(pio.getProductName());
            detailList.add(od);
        }
        orderDetailRepository.saveAll(detailList);
        response = restTemplate.postForObject(ServiceUtil.PRODUCT_API + "/product/decreaseStock/", form.getOrderDetail(), Response.class);
        System.out.println(response);
        return om;
    }
}
