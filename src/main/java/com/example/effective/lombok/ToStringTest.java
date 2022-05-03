package com.example.effective.lombok;

import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

/**
 * @ToString 注解 生成toString方法
 *
 * @author fuhaixin
 * @date 2022/5/2
 */
@ToString(
    //    callSuper = true,
    includeFieldNames = false,
    //    exclude = {"field1"},与of有冲突
    //    of = {"field1"},
    doNotUseGetters = true
    //
    )
public class ToStringTest {
  @Setter private String field1;
  @Setter private String field2;

  public String getField2() {
    System.out.println("调用get方法");
    return field2;
  }

  @Test
  public void test() {
    var toStringTest = new ToStringTest();
    toStringTest.setField1("zhangsan");

    toStringTest.setField2("lisi");
    System.out.println(toStringTest.toString());
  }
}
