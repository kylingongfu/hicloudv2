package org.zhang.cloud.order.entity;

import javax.persistence.*;

@Entity
public class OrderDetail {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int detailId;



  //private String orderId;

  @ManyToOne
  @JoinColumn(name = "order_id"
  )
  /*@JoinColumn(name = "person_id",
          foreignKey = @ForeignKey(name = "PERSON_ID_FK")
  )*/
  private OrderMaster orderMaster;
  private String productId;
  private String productName;
  private double productPrice;
  private long productQuantity;
  private String productIcon;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public int getDetailId() {
    return detailId;
  }

  public void setDetailId(int detailId) {
    this.detailId = detailId;
  }


  /*public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }*/

  public OrderMaster getOrderMaster() {
    return orderMaster;
  }

  public void setOrderMaster(OrderMaster orderMaster) {
    this.orderMaster = orderMaster;
  }
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


  public long getProductQuantity() {
    return productQuantity;
  }

  public void setProductQuantity(long productQuantity) {
    this.productQuantity = productQuantity;
  }


  public String getProductIcon() {
    return productIcon;
  }

  public void setProductIcon(String productIcon) {
    this.productIcon = productIcon;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

}
