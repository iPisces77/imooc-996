package com.example.effective.lombok;

import lombok.Synchronized;

/**
 * @author fuhaixin
 * @date 2022/5/2
 */
public class SynchronizedTest {
  @Synchronized
  public void sycn() {
    System.out.println("Hello World");
  }
}
