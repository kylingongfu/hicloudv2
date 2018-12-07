package org.zhang.cloud.order.form;

import lombok.Data;
import org.zhang.cloud.order.entity.OrderDetail;

import java.util.Date;
import java.util.List;

/**
 * @Auther: zhang
 * @Date: 2018/12/1 20:55
 * @Description:
 */

@Data
public class OrderForm {

    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private double orderAmount;
    private long orderStatus;
    private long payStatus;
    private Date createTime;
    private Date updateTime;
    private List<OrderDetail> orderDetail;
}
