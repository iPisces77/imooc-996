package com.example.effective.stream;

import com.alibaba.fastjson2.JSON;
import com.example.effective.CategoryEnum;
import com.example.effective.pojo.Sku;
import com.example.effective.service.CartService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/4/30
 */
public class StreamVs {
  /** 1.购物车中都有什么东西 2.图书类商品都给买 3.其余商品中买两件最贵的 4.只需要两家商品的名称和总价 */
  @Test
  public void oldCartHandle() {
    /** 打印所有商品 */
    var cartList = CartService.getCartList();
    for (Sku sku : cartList) {
      System.out.println(JSON.toJSONString(sku));
    }
    /** 图书类过滤掉 */
    var skus = new ArrayList<Sku>();
    for (Sku sku : cartList) {
      if (!CategoryEnum.BOOKS.equals(sku.getSkuCategory())) {
        skus.add(sku);
      }
    }
    /** 只需要两家商品的名称和总价 */
    skus.sort(
        new Comparator<Sku>() {
          @Override
          public int compare(Sku o1, Sku o2) {
            if (o1.getTotalPrice() > o2.getTotalPrice()) {
              return -1;
            } else if (o1.getTotalPrice() < o2.getTotalPrice()) {
              return 1;
            } else {
              return 0;
            }
          }
        });
    /** top2 */
    var top2SkuList = new ArrayList<Sku>();
    for (int i = 0; i < 2; i++) {
      //
      top2SkuList.add(skus.get(i));
    }
    /** 求两件商品的总价 */
    Double money = 0.0;
    for (Sku sku : top2SkuList) {
      money += sku.getTotalPrice();
    }
    /** 获取两件商品的名称 */
    var resultSkuNameList = new ArrayList<String>();
    for (Sku sku : top2SkuList) {
      resultSkuNameList.add(sku.getSkuName());
    }
    /** 打印输出结果 */
    System.out.println(JSON.toJSONString(resultSkuNameList));
    System.out.println("商品总价" + money);
  }

  @Test
  public void newCartHandle() {
    AtomicReference<Double> money = new AtomicReference<>(0.0);
    var cartList = CartService.getCartList();
    var collect =
        cartList.stream()
            .peek(
                sku -> {
                  System.out.println(JSON.toJSONString(sku));
                })
            .filter(
                sku -> {
                  return !CategoryEnum.BOOKS.equals(sku.getSkuCategory());
                })
            .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
            .limit(2)
            .peek(
                sku -> {
                  money.updateAndGet(v -> v + sku.getTotalPrice());
                })
            .map(
                sku -> {
                  return sku.getSkuName();
                })
            .collect(Collectors.toList());
    System.out.println(JSON.toJSONString(collect));
    System.out.println("商品总价" + money.get());
  }
}
