package com.example.effective;

import com.alibaba.fastjson2.JSON;
import com.example.effective.service.CartService;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/4/30
 */
public class Version1Test {
  @Test
  public void filterElectroinics() {
    var cartService = new CartService();
    var cartList = CartService.getCartList();
    var skus = cartService.filterElectroinics(cartList);
    System.out.println(JSON.toJSONString(skus));
  }
}
