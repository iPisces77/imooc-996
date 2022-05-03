package com.example.effective.pojo;

/**
 * 下单商品信息对象
 *
 * @author fuhaixin
 * @date 2022/4/30
 */
public class Sku {
  // 编号
  private Integer skuId;
  // 商品名称
  private String skuName;
  // 商品价格
  private Double skuPrice;
  // 商品数量
  private Integer totalNum;
  // 商品总价
  private Double totalPrice;
  // 商品类型
  private Enum skuCategory;

  public Sku() {}

  public Integer getSkuId() {
    return skuId;
  }

  public void setSkuId(Integer skuId) {
    this.skuId = skuId;
  }

  public String getSkuName() {
    return skuName;
  }

  public void setSkuName(String skuName) {
    this.skuName = skuName;
  }

  public Double getSkuPrice() {
    return skuPrice;
  }

  public void setSkuPrice(Double skuPrice) {
    this.skuPrice = skuPrice;
  }

  public Integer getTotalNum() {
    return totalNum;
  }

  public void setTotalNum(Integer totalNum) {
    this.totalNum = totalNum;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Enum getSkuCategory() {
    return skuCategory;
  }

  public void setSkuCategory(Enum skuCategory) {
    this.skuCategory = skuCategory;
  }

  public Sku(Integer skuId, String skuName, Double skuPrice, Integer totalNum, Double totalPrice,
      Enum skuCategory) {
    this.skuId = skuId;
    this.skuName = skuName;
    this.skuPrice = skuPrice;
    this.totalNum = totalNum;
    this.totalPrice = totalPrice;
    this.skuCategory = skuCategory;

  }
}
