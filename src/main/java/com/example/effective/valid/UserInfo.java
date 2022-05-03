package com.example.effective.valid;

import java.time.LocalDate;
import java.util.List;
import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * 待验证端对象实体类
 *
 * @author fuhaixin
 * @date 2022/5/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

  /** 用户Id */
  @NotNull(
      message = "用户Id不能为空",
      groups = {LoginGroup.class})
  private String userId;
  /** 用户名 */
  @NotEmpty(message = "用户名不能为空")
  private String userName;
  /** 用户密码 */
  @NotBlank(message = "用户密码不能为空")
  @Length(min = 6, max = 20, message = "密码长度必须在6-20之间")
  private String passWord;
  /** 邮箱 */
  @Email(
      message = "邮箱格式不正确",
      groups = {RegisterGroup.class})
  private String email;

  @Min(value = 18, message = "年龄必须大于18")
  @Max(value = 60, message = "年龄必须小于60")
  private Integer age;
  /** 手机号 */
  @Phone private String mobile;

  /** 生日 */
  @Past(message = "生日必须是过去的时间")
  private LocalDate birthday;
  /** 好友列表 */
  @Size(min = 1, message = "好友列表不能为空")
  private List<@Valid UserInfo> friends;

  public interface LoginGroup {}

  public interface RegisterGroup {}

  /** 组排序 */
  @GroupSequence({LoginGroup.class, RegisterGroup.class, Default.class})
  public interface Group {}
}
