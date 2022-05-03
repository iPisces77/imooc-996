package com.example.effective;

import com.example.effective.lambda.file.FileService;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/4/30
 */
public class FileServiceTest {
  @Test
  public void fileHandle() {
    FileService fileService = new FileService();
    // 通过lambda表达式,打印文件内容
    fileService.fileHandle("D:\\file01.txt", fileContent -> System.out.println(fileContent));
  }
}
