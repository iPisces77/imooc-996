package com.example.effective.lambda.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文件服务类
 *
 * @author fuhaixin
 * @date 2022/4/30
 */
public class FileService {

  /**
   * 通过url获取本地文件内容,调用函数式接口处理
   *
   * @param url
   * @param consumer
   */
  public void fileHandle(String url, FileConsumer consumer) {
    try (var bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {
      var stringBuilder = new StringBuilder();
      String line = null;
      // 循环读取
      while ((line = bufferedReader.readLine()) != null) {
        stringBuilder.append(line + "\n");
      }
      // 调用函数式接口方法,将文件内容传递给lambda表达式,实现业务逻辑
      consumer.fileHandle(stringBuilder.toString());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
