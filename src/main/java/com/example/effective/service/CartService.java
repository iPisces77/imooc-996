package com.example.effective.service;

import com.example.effective.CategoryEnum;
import com.example.effective.SkuPredicate;
import com.example.effective.pojo.Sku;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fuhaixin
 * @date 2022/4/30
 */
public class CartService {
  // 加入到购物车中的商品信息

  public static List<Sku> cartList =
      new ArrayList<>() {
        {
          add(new Sku(654032, "无人机", 4999.00, 1, 4999.00, CategoryEnum.ELECTRONICS));

          add(new Sku(642934, "VR一体机", 2299.00, 1, 2299.00, CategoryEnum.ELECTRONICS));

          add(new Sku(645321, "纯色衬衫", 409.00, 3, 1227.00, CategoryEnum.CLOTHING));

          add(new Sku(654327, "牛仔裤", 528.00, 1, 528.00, CategoryEnum.CLOTHING));

          add(new Sku(675489, "跑步机", 2699.00, 1, 2699.00, CategoryEnum.SPORTS));

          add(new Sku(644564, "Java编程思想", 79.80, 1, 79.80, CategoryEnum.BOOKS));

          add(new Sku(678678, "Java核心技术", 149.00, 1, 149.00, CategoryEnum.BOOKS));

          add(new Sku(697894, "算法", 78.20, 1, 78.20, CategoryEnum.BOOKS));

          add(new Sku(696968, "TensorFlow进阶指南", 85.10, 1, 85.10, CategoryEnum.BOOKS));
        }
      };

  public static List<Sku> getCartList() {
    return cartList;
  }

  /**
   * 找出购物车中所有电子产品
   *
   * @version 1.0
   * @return
   */
  public List<Sku> filterElectronics(List<Sku> cartList) {
    var result = new ArrayList<Sku>();
    for (Sku sku : cartList) {
      //
      if (CategoryEnum.ELECTRONICS == sku.getSkuCategory()) {
        result.add(sku);
      }
    }
    return result;
  }

  /**
   * 根据传入商品类型参数,找出购物车中同种商品类型的商品列表
   *
   * @param cartList
   * @param category
   * @return
   */
  public static List<Sku> filterSkuByCategory(List<Sku> cartList, CategoryEnum category) {
    var result = new ArrayList<Sku>();
    for (Sku sku : cartList) {
      //
      if (category == sku.getSkuCategory()) {
        result.add(sku);
      }
    }
    return result;
  }

  /**
   * 通过商品类型或总价来过滤商品.
   *
   * @param cartList
   * @param category
   * @param totalPrice
   * @param categoryOrPrice -true:根据商品类型 false:根据商品总价
   * @return
   */
  public static List<Sku> filterSku(
      List<Sku> cartList, CategoryEnum category, Double totalPrice, Boolean categoryOrPrice) {
    var result = new ArrayList<Sku>();
    for (Sku sku : cartList) {
      //
      if ((categoryOrPrice && category == sku.getSkuCategory())
          || (!categoryOrPrice && sku.getTotalPrice() > totalPrice)) {

        result.add(sku);
      }
    }
    return result;
  }

  /**
   * 根据不同的Sku判断标准,对Sku进行过滤
   *
   * @param cartList
   * @param skuPredicate
   * @return
   */
  public static List<Sku> filterSku(List<Sku> cartList, SkuPredicate skuPredicate) {
    var result = new ArrayList<Sku>();
    for (Sku sku : cartList) {
      if (skuPredicate.test(sku)) {
        result.add(sku);
      }
    }
    return result;
  }
}
