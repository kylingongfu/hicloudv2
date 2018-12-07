package org.zhang.cloud.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zhang.cloud.order.entity.OrderDetail;

/**
 * @Auther: zhang
 * @Date: 2018/12/7 14:26
 * @Description:
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
}
