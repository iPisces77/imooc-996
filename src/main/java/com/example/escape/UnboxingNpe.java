package com.example.escape;

/**
 * 自动拆箱引发的空指针问题.
 *
 * @author fuhaixin
 * @date 2022/5/2
 */
public class UnboxingNpe {
  public static void main(final String[] args) {
    // 第一种情况: 变量赋值自动拆箱出现的空指针
    //    Long count = null;
    //    long count_ = count;
    // 第二种情况:方法传参时自动拆箱引发的空指针
//    Integer left = null;
//    Integer right = null;
//    System.out.println(add(left, right));
    // 第三种情况:用于大小比较的场景
    Long a= null;
    Long b = 10L;
    System.out.println(compare(a, b));
  }

  private static int add(int a, int b) {
    return a + b;
  }
  private static Boolean compare(long a, long b) {
    return a > b;
  }
}
