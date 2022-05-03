package com.example.effective.lombok;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fuhaixin
 * @date 2022/5/2
 */
@Slf4j
public class LogTest {
  public static final Logger Log = LoggerFactory.getLogger(LogTest.class);

  @Test
  public void func() {
    log.info("日志");
  }
}
