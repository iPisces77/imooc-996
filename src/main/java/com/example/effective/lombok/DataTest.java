package com.example.effective.lombok;

import lombok.Data;

/**
 * @Data 注解包含@Getter,@Setter,@ToString,@EqualsAndHashCode
 *
 * @author fuhaixin
 * @date 2022/5/2
 */
@Data
public class DataTest {
  private String field1;
  private String field2;
}
