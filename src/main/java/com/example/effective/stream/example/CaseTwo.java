package com.example.effective.stream.example;

import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/5/1
 */
public class CaseTwo {
  /** 用户请求的创建标签模型 */
  @Data
  @AllArgsConstructor
  class TagReqDTO {
    /** 标签名字 */
    private String name;
    /** 标签值：年龄 */
    private Integer age;
  }

  /** 从DB中查询出来的已经存在的标签名 */
  List<String> tagListFromDB;
  /** 用户请求的标签列表 */
  List<TagReqDTO> tagListFromReq;

  @BeforeEach
  public void init() {
    // 数据库中存在的标签名列表
    tagListFromDB = Lists.newArrayList("李四", "王五", "赵六");

    // 用户提交的
    tagListFromReq =
        Lists.newArrayList(
            new TagReqDTO("张三", 10), new TagReqDTO("李四", 30), new TagReqDTO("张三", 10));
  }

  @Test
  public void distinctTag() {
    tagListFromReq.stream()
        .filter(
            tagReqDTO -> {
              return !tagListFromDB.contains(tagReqDTO.getName());
            })
        .distinct()
        .forEach(
            tagReqDTO -> {
              System.out.println(JSON.toJSONString(tagReqDTO));
            });
  }
}
