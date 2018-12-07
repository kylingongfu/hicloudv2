package org.zhang.cloud.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhang.cloud.product.entity.ProductInfo;
import org.zhang.cloud.product.enums.ResultEnum;
import org.zhang.cloud.product.exception.ProductException;
import org.zhang.cloud.product.repository.ProductInfoRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductInfoRepository productInfoRepository;

    public ProductInfo findById(String id) {
        return productInfoRepository.findById(id).get();
    }

    public Iterable<ProductInfo> findAll() {
        return productInfoRepository.findAll();
    }

    public List<ProductInfo> findByStatus(int status) {
        return productInfoRepository.findByProductStatus(status);
    }

    @Transactional
    public List<ProductInfo> decreaseStock(List<ProductInfo> piList) {
        ArrayList<ProductInfo> productInfos = new ArrayList<>();
        for (ProductInfo pi : piList) {
            Optional<ProductInfo> getPi = productInfoRepository.findById(pi.getProductId());
            if (!getPi.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXSIT);
            }
            ProductInfo tmpPi = getPi.get();
            long leftStock = tmpPi.getProductStock() - pi.getProductStock();
            if (leftStock < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STORCK_ERROR);
            }
            tmpPi.setProductStock(leftStock);
            productInfos.add(tmpPi);
        }

        return  productInfoRepository.saveAll(productInfos);
    }
}
