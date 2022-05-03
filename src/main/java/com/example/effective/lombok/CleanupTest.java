package com.example.effective.lombok;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import lombok.Cleanup;

/**
 * @CleanUp注解 资源关闭
 *
 * @author fuhaixin
 * @date 2022/5/2
 */
public class CleanupTest {
  public static void main(String[] args) {
    //

  }

  public void copyFile(String in, String out) throws IOException {
    @Cleanup var fileInputStream = new FileInputStream(in);
    @Cleanup var fileOutputStream = new FileOutputStream(out);
    int r;
    while ((r = fileInputStream.read()) != -1) {
      fileOutputStream.write(r);
    }
  }
}
