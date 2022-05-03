package com.example.effective.lambda.file;

/**
 * @author fuhaixin
 * @date 2022/4/30
 */
@FunctionalInterface
public interface FileConsumer {
  void fileHandle(String fileContent);
}
