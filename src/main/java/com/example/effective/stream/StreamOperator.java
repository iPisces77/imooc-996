package com.example.effective.stream;

import com.alibaba.fastjson2.JSON;
import com.example.effective.CategoryEnum;
import com.example.effective.pojo.Sku;
import com.example.effective.service.CartService;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/4/30
 */
public class StreamOperator {
  static List<Sku> list;

  @BeforeAll
  public static void beforeAll() {
    list = CartService.getCartList();
  }

  /** 过滤掉不符合断言判断的数据 */
  @Test
  public void filterTest() {
    list.stream()
        .filter(sku -> CategoryEnum.BOOKS.equals(sku.getSkuCategory()))
        .forEach(item -> System.out.println(JSON.toJSONString(item)));
  }

  /** map的使用,降一个元素转换成另一个元素 */
  @Test
  public void mapTest() {
    list.stream().map(Sku::getSkuName).forEach(item -> System.out.println(item));
  }

  /** flatMap使用,将一个对象转换为流 */
  @Test
  public void flatMapTest() {
    list.stream()
        .flatMap(
            sku -> {
              return Arrays.stream(sku.getSkuName().split(""));
            })
        .forEach(item -> System.out.println(JSON.toJSONString(item)));
  }
  /** peek使用:对流中元素进行遍历操作,与foreach类似,但不会销毁元素 */
  @Test
  public void peekTest() {
    list.stream()
        .peek(
            sku -> {
              System.out.println(sku.getSkuName());
            })
        .forEach(item -> System.out.println(JSON.toJSONString(item)));
  }

  /** 对流中的元素进行排序 */
  @Test
  public void sorted() {
    list.stream()
        .sorted(Comparator.comparing(Sku::getTotalPrice))
        .forEach(item -> System.out.println(JSON.toJSONString(item)));
  }

  /** 对流中元素进行去重 */
  @Test
  public void distinctTest() {
    list.stream()
        .map(sku -> sku.getSkuCategory())
        .distinct()
        .forEach(item -> System.out.println(JSON.toJSONString(item)));
  }

  /** skip使用:跳过前N条记录,有状态 */
  @Test
  public void skipTest() {
    list.stream()
        .sorted(Comparator.comparing(Sku::getTotalPrice))
        .skip(3)
        .forEach(item -> System.out.println(JSON.toJSONString(item)));
  }

  /** 截断前N条记录,有状态 */
  @Test
  public void limitTest() {
    list.stream()
        .sorted(Comparator.comparing(Sku::getTotalPrice))
        .limit(3)
        .forEach(item -> System.out.println(JSON.toJSONString(item)));
  }

  /** 终端操作,短路操作 */
  @Test
  public void allMatch() {
    var flag = list.stream().allMatch(sku -> sku.getTotalPrice() >= 100);
    System.out.println(flag);
  }

  /** anyMatch使用:任何元素匹配,返回true */
  @Test
  public void anyMatch() {
    var flag = list.stream().anyMatch(sku -> sku.getTotalPrice() >= 100);
    System.out.println(flag);
  }

  /** noneMatch使用:任何元素不匹配,返回true */
  @Test
  public void noneMatchTest() {
    var flag = list.stream().noneMatch(sku -> sku.getTotalPrice() >= 10_000);
    System.out.println(flag);
  }

  @Test
  public void findFirstTest() {
    var optional = list.stream().findFirst();
    System.out.println(JSON.toJSONString(optional.get()));
  }

  @Test
  public void findAnyTest() {
    var optional = list.stream().findAny();
    System.out.println(JSON.toJSONString(optional.get()));
  }
  @Test
  public void maxTest(){
    var max = list.stream().mapToDouble(Sku::getTotalPrice).max();
    System.out.println(JSON.toJSONString(max.getAsDouble()));

  }
  @Test
  public void countTest(){
    var count = list.stream().count();
    System.out.println(JSON.toJSONString(count));
  }
}
