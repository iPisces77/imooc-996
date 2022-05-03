package com.example.effective.lombok;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.Setter;

/**
 * @Setter 注解 为属性生成set方法
 *
 * @author fuhaixin
 * @date 2022/5/2
 */
public class SetterTest {
  @Setter private String field1;

  @Setter(
      value = AccessLevel.PRIVATE,
      onParam_ = {@NonNull},
      onMethod_ = {@NonNull})
  private String field2;
}
