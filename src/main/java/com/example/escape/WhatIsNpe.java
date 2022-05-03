package com.example.escape;

/**
 * 什么是空指针
 *
 * @author fuhaixin
 * @date 2022/5/2
 */
public class WhatIsNpe {
  public static class User {
    private String name;
    private String[] address;

    public void print() {
      System.out.println("This is User class");
    }

    public String readBook() {
      System.out.println("User read book");
      return null;
    }
  }

  public static void main(String[] args) {
    // 第一种情况:调用了空对象的实例方法
    //    User user = null;
    //    user.print();
    // 第二种情况:访问了空对象的属性
    //    System.out.println(user.name);
    // 第三种情况:当数组是一个空对象,取他的长度会出现空指针
    // var user = new User();
    //    System.out.println(user.address.length);
    // 第四种情况:null当作Throwable的值
    //    CustomerException exception = null;
    //    throw exception;
    // 第五种情况:方法的返回值是null,调用者去调用
    User user = new User();
    System.out.println(user.readBook().contains("MySQL"));
  }

  /** 自定义一个运行时异常 */
  public static class CustomerException extends RuntimeException {}
}
