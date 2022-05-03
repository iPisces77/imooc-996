package com.example.effective.guava;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/5/1
 */
public class ImmutableTest {
  public static void test(List<Integer> list) {
    //
    list.remove(0);
  }

  public static void main(String[] args) {
    var newList = List.of(1, 2, 3);
    test(newList);
    System.out.println(newList);
  }

  @Test
  public void immutable() {
    var list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    var newList = ImmutableList.copyOf(list);
    newList = ImmutableList.of(1, 2, 3);
//    ImmutableList<Integer> newerList = ImmutableList.builder().add(1).addAll(list).build();
    test(newList);
  }
}
