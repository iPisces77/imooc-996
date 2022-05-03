package com.example.effective.lombok;

import lombok.EqualsAndHashCode;

/**
 * @EuqalsAndHashCode 注解 生成Equals方法和HashCode方法
 *
 * @author fuhaixin
 * @date 2022/5/2
 */
@EqualsAndHashCode(exclude = {"field1"})
public class EqualsAndHashCodeTest {
  private String field1;
  private String field2;
}
