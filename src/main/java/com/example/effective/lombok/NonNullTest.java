package com.example.effective.lombok;

import lombok.NonNull;

/**
 * @NonNull 注解,生成非空检查
 *
 * @author fuhaixin
 * @date 2022/5/2
 */
public class NonNullTest {

  public NonNullTest(@NonNull String field) {
    System.out.println(field);
  }
}
