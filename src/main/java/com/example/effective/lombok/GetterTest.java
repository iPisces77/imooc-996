package com.example.effective.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;

/**
 * @Getter 注解,为属性生成get方法
 *
 * @author fuhaixin
 * @date 2022/5/2
 */
public class GetterTest {
  @Getter(lazy = true)
  private final String field1 = "zhangsan";

  @Getter(
      value = AccessLevel.PRIVATE,
      onMethod_ = {@NonNull})
  private String field2;
}
