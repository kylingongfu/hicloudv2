package org.zhang.cloud.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zhang.cloud.order.entity.OrderMaster;

/**
 * @Auther: zhang
 * @Date: 2018/12/1 21:40
 * @Description:
 */
public interface OrderRepository extends JpaRepository<OrderMaster,String>{
}
