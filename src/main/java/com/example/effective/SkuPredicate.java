package com.example.effective;

import com.example.effective.pojo.Sku;

/**
 * @author fuhaixin
 * @date 2022/4/30
 */
@FunctionalInterface
public interface SkuPredicate {

  /**
   * 选择判断标准.
   *
   * @param sku
   * @return
   */
  boolean test(Sku sku);
}
