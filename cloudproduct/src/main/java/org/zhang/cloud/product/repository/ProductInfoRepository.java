package org.zhang.cloud.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zhang.cloud.product.entity.ProductInfo;

@Repository
public interface ProductInfoRepository extends CrudRepository<ProductInfo,String> {
}
