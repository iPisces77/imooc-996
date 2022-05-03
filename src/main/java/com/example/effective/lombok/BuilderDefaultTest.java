package com.example.effective.lombok;

import com.alibaba.fastjson2.JSON;
import java.util.Random;
import lombok.Builder;
import lombok.Data;

/**
 * @author fuhaixin
 * @date 2022/5/2
 */
@Builder
@Data
public class BuilderDefaultTest {

  @Builder.Default private final String id = String.valueOf(new Random().nextInt());

  private String username;

  @Builder.Default private long insertTime = System.currentTimeMillis();

  public static void main(String[] args) {
    var build = BuilderDefaultTest.builder().build();
    System.out.println(JSON.toJSONString(build));

  }
}
