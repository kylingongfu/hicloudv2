package org.zhang.cloud.order.form;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

public class ProductInfoForm {

    private String productId;
    private String productName;
    private double productPrice;
    private long productStock;
    private String productDescription;
    private String productIcon;
    private int productStatus;
    private long categoryType;
    private String createTime;
    private String updateTime;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }


    public long getProductStock() {
        return productStock;
    }

    public void setProductStock(long productStock) {
        this.productStock = productStock;
    }


    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }


    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }


    public long getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }


    public long getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(long categoryType) {
        this.categoryType = categoryType;
    }


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ProductInfoForm{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productStock=" + productStock +
                ", productDescription='" + productDescription + '\'' +
                ", productIcon='" + productIcon + '\'' +
                ", productStatus=" + productStatus +
                ", categoryType=" + categoryType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
