package org.zhang.cloud.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: zhang
 * @Date: 2018/12/1 21:40
 * @Description:
 */
public interface OrderRepository<OrderMaster,String> extends JpaRepository{
}
