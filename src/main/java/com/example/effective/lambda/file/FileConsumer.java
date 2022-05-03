package com.example.effective.lambda;

/**
 * @author fuhaixin
 * @date 2022/4/30
 */
@FunctionalInterface
public interface FileConsumer {
  void fileHandle(String fileContent);
}
