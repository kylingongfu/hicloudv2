package org.zhang.cloud.order.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OrderDetail {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int detailId;

  @Override
  public String toString() {
    return "OrderDetail{" +
            "detailId=" + detailId +
            ", orderMaster=" + orderMaster +
            ", productId='" + productId + '\'' +
            ", productName='" + productName + '\'' +
            ", productPrice=" + productPrice +
            ", productQuantity=" + productQuantity +
            ", productIcon='" + productIcon + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
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
  private Date createTime;
  private Date updateTime;


  /*@Column(name = "order_id")
  private String orderId;*/


  public int getDetailId() {
    return detailId;
  }

  public void setDetailId(int detailId) {
    this.detailId = detailId;
  }


 /* public String getOrderId() {
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


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

}
