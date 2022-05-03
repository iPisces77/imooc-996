package com.example.effective.lombok;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author fuhaixin
 * @date 2022/5/2
 */
@RequiredArgsConstructor
@AllArgsConstructor(staticName = "of")

public class ConstructorTest {
  private final String field1;
  @NonNull private String field2;
  private String field3;
  private final String field4 = "已完成初始化的字段";
}
