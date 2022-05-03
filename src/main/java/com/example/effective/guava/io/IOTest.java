package com.example.effective.guava.io;

import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/5/1
 */
public class IOTest {
  @Test
  public void copyFile() throws IOException {
    /** 创建对应的Source和Sink */
    CharSource charSource = Files.asCharSource(new File("SourceText.txt"), StandardCharsets.UTF_8);
    CharSink charSink = Files.asCharSink(new File("TargetText.txt"), StandardCharsets.UTF_8);
    /** 拷贝 */
    charSource.copyTo(charSink);

  }
}
