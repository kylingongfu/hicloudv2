package org.zhang.cloud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhang.cloud.product.entity.ProductInfo;
import org.zhang.cloud.product.repository.ProductInfoRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductInfoRepository repository;

    public ProductInfo findById(String id) {
        return repository.findById(id).get();
    }

    public Iterable<ProductInfo> findAll() {
        return repository.findAll();
    }

    public List<ProductInfo> findByStatus(int status){
        return repository.findByProductStatus(status);
    }
}