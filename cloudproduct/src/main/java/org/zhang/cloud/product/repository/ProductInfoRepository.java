package org.zhang.cloud.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zhang.cloud.product.entity.ProductInfo;

import java.util.List;

@Repository
public interface ProductInfoRepository extends CrudRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(int status);
}
