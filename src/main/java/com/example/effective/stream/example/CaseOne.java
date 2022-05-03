package com.example.effective.stream.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/5/1
 */
public class CaseOne {
  /** 考试成绩模型 */
  @Data
  @AllArgsConstructor
  class ExamStudentScore {
    /** 学生姓名 */
    private String studentName;
    /** 成绩 */
    private Integer scoreValue;
    /** 科目 */
    private String subject;
  }

  /** 学生考试成绩 */
  Map<String, List<ExamStudentScore>> studentMap;

  @BeforeEach
  public void init() {
    studentMap = new HashMap<>();

    List<ExamStudentScore> zsScoreList = new ArrayList<>();
    zsScoreList.add(new ExamStudentScore("张三", 30, "CHINESE"));
    zsScoreList.add(new ExamStudentScore("张三", 40, "ENGLISH"));
    zsScoreList.add(new ExamStudentScore("张三", 50, "MATHS"));
    studentMap.put("张三", zsScoreList);

    List<ExamStudentScore> lsScoreList = new ArrayList<>();
    lsScoreList.add(new ExamStudentScore("李四", 80, "CHINESE"));
    lsScoreList.add(new ExamStudentScore("李四", null, "ENGLISH"));
    lsScoreList.add(new ExamStudentScore("李四", 100, "MATHS"));
    studentMap.put("李四", lsScoreList);

    List<ExamStudentScore> wwScoreList = new ArrayList<>();
    wwScoreList.add(new ExamStudentScore("王五", null, "CHINESE"));
    wwScoreList.add(new ExamStudentScore("王五", null, "ENGLISH"));
    wwScoreList.add(new ExamStudentScore("王五", 70, "MATHS"));
    studentMap.put("王五", wwScoreList);
  }

  @Test
  public void findStudent() {
    studentMap.forEach(
        (studentName, scoreList) -> {
          var b =
              scoreList.stream()
                  .anyMatch(
                      examStudentScore -> {
                        return examStudentScore.getScoreValue() == null;
                      });
          if (b) {
            System.out.println(studentName + "有缺考的情况");
          }
        });
    //    anyMatch找到任意一条符合条件的数据后就停止
  }
}
