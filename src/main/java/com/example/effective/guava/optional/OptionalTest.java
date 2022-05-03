package com.example.effective.guava.optional;

import com.google.common.collect.Range;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/5/1
 */
public class OptionalTest {
  @Test
  public void test() {
    /** 三种创建Optional对象的方式 */
    var empty = Optional.empty();
    Optional.of("zhangsan");
    var optional = Optional.ofNullable("zhangsan");
    /** 判断Optional引用是否缺失(建议不使用) */
    optional.isPresent();
    /** 当optional引用存在是执行 类似的map,filter,flatmap */
    optional.ifPresent(System.out::println);
    /** 当optional引用缺失时执行 */
    optional.orElse("引用缺失");
    optional.orElseGet(
        () -> {
          return "自定义引用缺失";
        });
    optional.orElseThrow(
        () -> {
          throw new RuntimeException("引用缺失异常");
        });
  }

  public static void stream(List<String> list) {
    //    list.stream().forEach(System.out::println);
    Optional.ofNullable(list)
        .map(List::stream)
        .orElseGet(Stream::empty)
        .forEach(System.out::println);
  }

  public static void main(String[] args) {
    stream(null);

  }
}
