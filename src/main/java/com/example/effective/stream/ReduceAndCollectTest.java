package com.example.effective.stream;

import com.alibaba.fastjson2.JSON;
import java.util.HashMap;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * 规约与汇总操作
 *
 * @author fuhaixin
 * @date 2022/5/1
 */
public class ReduceAndCollectTest {
  @Test
  public void reduceTest() {
    /** 订单对象 */
    @Data
    @AllArgsConstructor
    class Order {
      /** 订单编号 */
      private Integer id;
      /** 用户编号 */
      private String account;
      /** 商品数量 */
      private Integer productCount;
      /** 消费总金额 */
      private Double totalAmount;
    }
    var list =
        List.of(
            new Order(1, "zhangxiaoxi", 2, 25.12),
            new Order(2, "zhangxiaoxi", 5, 257.23),
            new Order(3, "lisi", 3, 23332.1));
    /** 1.计算商品数量 2.计算消费总金额 */
    var reduce =
        list.stream()
            .reduce(
                // 初始值
                new Order(0, "zhangxiaoxi", 0, 0.0),
                // 两个元素的计算逻辑
                (Order order1, Order order2) -> {
                  var productionCount = order1.getProductCount() + order2.getProductCount();
                  var totalAmount = order1.getTotalAmount() + order2.getTotalAmount();
                  return new Order(0, "zhangxiaoxi", productionCount, totalAmount);
                },
                // 并行情况下,多个并行结果如何合并
                (Order order1, Order order2) -> {
                  var productionCount = order1.getProductCount() + order2.getProductCount();
                  var totalAmount = order1.getTotalAmount() + order2.getTotalAmount();
                  return new Order(0, "zhangxiaoxi", productionCount, totalAmount);
                });
    System.out.println(JSON.toJSONString(reduce));
    /** Map<用户账号,订单(数量和金额)></用户账号,订单(数量和金额)> */
    var collect =
        list.stream()
            .collect(
                HashMap::new,
                (HashMap<String, Order> map, Order newOrder) -> {
                  /*
                  新元素account已经在map中存在了,不存在
                   */
                  // 如果此账号已存在,将新订单数据类加上
                  var account = newOrder.getAccount();
                  if (map.containsKey(account)) {
                    var order = map.get(account);
                    order.setProductCount(order.getProductCount() + newOrder.getProductCount());
                    order.setTotalAmount(order.getTotalAmount() + newOrder.getTotalAmount());

                  } else {
                    // 如果不存在,则加入新订单
                    map.put(account, newOrder);
                  }
                },
                (HashMap<String, Order> map1, HashMap<String, Order> map2) -> {
                  System.out.println("执行 并行结果合并 操作!!!");
                  map2.forEach(
                      (key, value) ->
                         // 一定使用map1做合并,因为最后collect收集的是map1
                          map1.merge(
                              key,
                              value,
                              ((order1, order2) -> {
                                // 返回的是map1集合
                                return new Order(
                                    0,
                                    key,
                                    order1.getProductCount() + order1.getProductCount(),
                                    order1.getTotalAmount() + order1.getTotalAmount());
                              })));
                });
    System.out.println(JSON.toJSONString(collect));

  }
}
