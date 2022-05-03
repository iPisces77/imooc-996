package com.example.effective;

/**
 * 商品类型枚举
 *
 * @author fuhaixin
 * @date 2022/4/30
 **/
public enum CategoryEnum {
  CLOTHING(10,"服装"),
  ELECTRONICS(20,"数码类"),
  SPORTS(30,"运动类"),
  BOOKS(40,"图书类");

  CategoryEnum(Integer code, String name) {
    this.code = code;
    this.name = name;
  }



  //商品类型的编号
  private final Integer code;
  //商品类型的名称
  private final String name;

}
