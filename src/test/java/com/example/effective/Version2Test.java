package com.example.effective;

import com.alibaba.fastjson2.JSON;
import com.example.effective.service.CartService;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/4/30
 */
public class Version2Test {
  @Test
  public void filterSkuByCategory() {
    var cartList = CartService.getCartList();
    var skus = CartService.filterSkuByCategory(cartList, CategoryEnum.BOOKS);
    System.out.println(JSON.toJSONString(skus));
  }
}
