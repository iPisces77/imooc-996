package com.example.effective.stream.example;

import com.alibaba.fastjson2.JSON;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/5/1
 */
public class CaseFive {
  /** 交易实体模型 */
  @Data
  @AllArgsConstructor
  class Trade {
    // 下单价格
    private BigDecimal price;
    // 下单时间
    private LocalDateTime time;
    // 下单量
    private Integer count;
    // 下单类型：机构 / 个人
    private String type;
  }

  /** 一段时间内的交易申请 */
  List<Trade> trades;

  @BeforeEach
  public void init() {
    trades = new ArrayList<>();

    trades.add(
        new Trade(
            new BigDecimal(100),
            // 在当前时间的基础上添加 1 秒
            LocalDateTime.now().plusSeconds(1),
            500,
            "机构"));
    trades.add(new Trade(new BigDecimal(101), LocalDateTime.now().plusSeconds(2), 1, "个人"));
    trades.add(new Trade(new BigDecimal(101), LocalDateTime.now().plusSeconds(1), 1, "个人"));
    trades.add(new Trade(new BigDecimal(100), LocalDateTime.now().plusSeconds(1), 500, "个人"));
    trades.add(new Trade(new BigDecimal(100), LocalDateTime.now().plusSeconds(0), 2, "个人"));
    trades.add(new Trade(new BigDecimal(100), LocalDateTime.now().plusSeconds(0), 100, "机构"));
  }

  @Test
  public void sortTrade() {
    var collect =
        trades.stream()
            .sorted(
                Comparator.comparing(Trade::getPrice, Comparator.reverseOrder())
                    .thenComparing(Trade::getTime)
                    .thenComparing(Trade::getCount, Comparator.reverseOrder())
                    .thenComparing(
                        Trade::getType,
                        (type1, type2) -> {
                          if (Objects.equals(type1, "机构") && Objects.equals(type2, "个人")) {
                            return -1;
                          } else if (Objects.equals(type1, "个人") && Objects.equals(type2, "机构")) {
                            return 1;
                            //
                          } else {
                            return 0;
                          }
                        }))
            .collect(Collectors.toList());
    System.out.println(JSON.toJSONString(collect));
  }
}
