package com.example.effective;

import com.alibaba.fastjson2.JSON;
import com.example.effective.pojo.Sku;
import com.example.effective.service.CartService;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * 常见预定义收集器使用
 *
 * @author fuhaixin
 * @date 2022/5/1
 */
public class StreamCollector {
  @Test
  public void toList() {
    var cartList = CartService.getCartList();
    cartList.stream()
        .filter(
            sku -> {
              return sku.getTotalPrice() > 100;
            })
        .collect(Collectors.toList())
        .forEach(
            sku -> {
              System.out.println(JSON.toJSONString(sku));
            });
  }

  /** 分组 */
  @Test
  public void group() {
    var cartList = CartService.getCartList();
    var collect = cartList.stream().collect(Collectors.groupingBy(Sku::getSkuCategory));
    System.out.println(JSON.toJSONString(collect));
  }
  /** 分区 */
  @Test
  public void partition() {
    var cartList = CartService.getCartList();
    var collect =
        cartList.stream()
            .collect(
                Collectors.partitioningBy(
                    sku -> {
                      return sku.getTotalPrice() > 100;
                    }));
    System.out.println(JSON.toJSONString(collect));
  }
}
