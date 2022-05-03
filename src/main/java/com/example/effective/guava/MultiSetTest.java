package com.example.effective.guava;

import com.google.common.primitives.Chars;
import org.apache.commons.collections4.multiset.HashMultiSet;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/5/1
 */
public class MultiSetTest {
  @Test
  public void test() {
    var chars = text.toCharArray();
    var characters = new HashMultiSet<Character>();

    var list = Chars.asList(chars);
    characters.addAll(list);

    System.out.println(characters);
    System.out.println(characters.size());
    System.out.println(characters.getCount('人'));

  }

  private static final String text =
      "《南陵别儿童入京》"
          + "白酒新熟山中归，黄鸡啄黍秋正肥。"
          + "呼童烹鸡酌白酒，儿女嬉笑牵人衣。"
          + "高歌取醉欲自慰，起舞落日争光辉。"
          + "游说万乘苦不早，著鞭跨马涉远道。"
          + "会稽愚妇轻买臣，余亦辞家西入秦。"
          + "仰天大笑出门去，我辈岂是蓬蒿人。";
}
