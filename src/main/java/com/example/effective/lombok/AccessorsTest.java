package com.example.effective.lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author fuhaixin
 * @date 2022/5/2
 */
@Getter
@Setter
@Accessors(fluent = true)
public class AccessorsTest {
  private String field1;
  private String field2;

  public static void main(String[] args) {
    var accessorsTest = new AccessorsTest();
    accessorsTest.field1("field1").field2("field2");
  }
}
