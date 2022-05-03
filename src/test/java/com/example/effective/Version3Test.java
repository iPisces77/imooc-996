package com.example.effective;

import com.alibaba.fastjson2.JSON;
import com.example.effective.service.CartService;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/4/30
 */
public class Version3Test {
  @Test
  public void filterSku() {
    var cartList = CartService.getCartList();
    var skus = CartService.filterSku(cartList, null, 2000.00, false);
    System.out.println(JSON.toJSONString(skus));
  }
}
