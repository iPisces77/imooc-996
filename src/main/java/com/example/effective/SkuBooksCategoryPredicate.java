package com.example.effective;

import com.example.effective.pojo.Sku;

/**
 * 对Sku的商品类型为图书类的判断标准
 *
 * @author fuhaixin
 * @date 2022/4/30
 */
public class SkuBooksCategoryPredicate implements SkuPredicate {

  @Override
  public boolean test(Sku sku) {
    return CategoryEnum.BOOKS==(sku.getSkuCategory());
  }
}
