package com.example.effective;

import com.example.effective.pojo.Sku;

/**
 * 对Sku的总价是否超出2000作为判断标准
 *
 * @author fuhaixin
 * @date 2022/4/30
 */
public class SkuTotalPricePredicate implements SkuPredicate {

  @Override
  public boolean test(Sku sku) {
    return sku.getTotalPrice() > 2000;
  }
}
