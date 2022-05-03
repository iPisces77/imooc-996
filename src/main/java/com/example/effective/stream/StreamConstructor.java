package com.example.effective;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * 流的四种创建方式
 *
 * @author fuhaixin
 * @date 2022/5/1
 */
public class StreamConstructor {

  /** 由数值直接构建流 */
  @Test
  public void streamFromValue() {
    var integerStream = Stream.of(1, 2, 3, 4, 50);
    integerStream.forEach(System.out::println);
  }

  /** 通过数组构建流 */
  @Test
  public void streamFromArray() {
    int[] array = {1, 2, 3, 4, 5};
    var integerStream = Arrays.stream(array);
    integerStream.forEach(System.out::println);
  }
  /** 通过文件构建流 */
  @Test
  public void streamFromFile() throws IOException {
    var lines = Files.lines(Paths.get("D:\\file01.txt"));
    lines.forEach(System.out::println);
  }

  @Test
  public void streamFromFunction() {
//    var iterate = Stream.iterate(0, n -> n + 2);
    var generate = Stream.generate(Math::random);
    generate.limit(100).forEach(System.out::println);
//    iterate.forEach(System.out::println);
  }
}
