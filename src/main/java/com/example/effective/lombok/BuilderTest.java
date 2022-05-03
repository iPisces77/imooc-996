package com.example.effective.lombok;

import com.alibaba.fastjson2.JSON;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

/**
 * @author fuhaixin
 * @date 2022/5/2
 */
@Builder
@Data
@AllArgsConstructor
public class BuilderTest {
  private static String staticField;
//  private final String finalField;
  private String field1;
  @Builder.Default private String field2 = "init";
  private static final String initFinalField = "已初始化的Final字段";

  @Singular("listField")
  private List<String> listField;

  public BuilderTest() {
  }

  public static void main(String[] args) {
    var build =
        BuilderTest.builder()
//            .finalField("手动复制Final-field字段")
            .field1("手动赋值Field字段")
            .listField("张三")
            .listField("李四")
            //            .listField(new ArrayList<>())
            // 此时创建的对象是不可变得
            .build();
    System.out.println(JSON.toJSONString(build));
//    var builderTest = new BuilderTest();
//    System.out.println(JSON.toJSONString(builderTest));
  }
}
