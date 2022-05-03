package com.example.effective.lombok;

import java.util.ArrayList;
import lombok.val;

/**
 * @val 注解 弱语言变量
 * @author fuhaixin
 * @date 2022/5/2
 */
public class ValTest {

  public ValTest() {
    val field = "zhangsan";

    val list = new ArrayList<String>();
    list.add(field);
  }
}
