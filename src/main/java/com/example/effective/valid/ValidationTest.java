package com.example.effective.valid;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/5/2
 */
public class ValidationTest {
  private Validator validator;
  private UserInfo userInfo;
  private Set<ConstraintViolation<UserInfo>> set;
  private Set<ConstraintViolation<UserInfoService>> set2;

  @BeforeEach
  public void init() {
    // 初始化操作
    validator = Validation.buildDefaultValidatorFactory().getValidator();
    userInfo = new UserInfo();
    userInfo.setUserId("15");

    userInfo.setUserName("zhangsan");
    userInfo.setPassWord("zhangsan");
    userInfo.setEmail("zhangxiaoxi@sina.cn");
    userInfo.setMobile("1310010");
    userInfo.setAge(30);

    userInfo.setBirthday(LocalDate.of(1996, 3, 18));
    UserInfo friend = new UserInfo();
    friend.setUserId("wangxiaoxi");
    friend.setUserName("王小喜");
    friend.setPassWord("wangxiaoxi");
    friend.setEmail("wangxiaoxi@sina.cn");
    friend.setMobile("15811111111");

    var friends = new ArrayList<UserInfo>();
    friends.add(friend);

    userInfo.setFriends(friends);
  }

  @AfterEach
  public void print() {
    //    set.forEach(
    //        item -> {
    //          System.out.println(item.getMessage());
    //        });
    set2.forEach(
        item -> {
          System.out.println(item.getMessage());
        });
  }

  @Test
  public void nullValidation() {
    set = validator.validate(userInfo);
  }

  /** 级联验证测试方法 */
  @Test
  public void graphValidation() {
    set = validator.validate(userInfo);
  }

  /** 分组验证测试方法 */
  @Test
  public void GroupValidation() {
    set = validator.validate(userInfo, UserInfo.LoginGroup.class, UserInfo.RegisterGroup.class);
  }

  /** 组序列校验,分别校验不同组所属的校验规则,如果有错误会直接返回 */
  @Test
  public void groupSequenceValidation() {
    set = validator.validate(userInfo, UserInfo.Group.class);
  }
  /** 对方法端输入参数进行约束注解校验 */
  @Test
  public void paramValidation() throws NoSuchMethodException {
    // 获取校验执行器
    var executableValidator = validator.forExecutables();
    // 待验证对象
    var userInfoService = new UserInfoService();
    // 待验证方法
    var setUserInfo = userInfoService.getClass().getMethod("setUserInfo", UserInfo.class);
    // 方法输入参数
    var objects = new UserInfo[] {new UserInfo()};
    // 对方法的输入参数进行校验

    set2 = executableValidator.validateParameters(userInfoService, setUserInfo, objects);
  }

  /** 对方法返回值进行约束校验 */
  @Test
  public void returnValueValidation()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    // 获取校验执行器
    var executableValidator = validator.forExecutables();
    // 构造要验证的方法对象
    var userInfoService = new UserInfoService();
    var getUserInfo = userInfoService.getClass().getMethod("getUserInfo");
    // 调用方法得到返回值
    var invoke = getUserInfo.invoke(userInfoService);
    // 校验方法返回值是否符合约束
    set2 = executableValidator.validateReturnValue(userInfoService, getUserInfo, invoke);
  }
  /** 对构造函数输入参数进行校验 */
  @Test
  public void constructorValidation() throws NoSuchMethodException {
    // 获取校验执行器
    var executableValidator = validator.forExecutables();
    // 获取构造函数
    var constructor = UserInfoService.class.getConstructor(UserInfo.class);
    // 校验构造函数
    var objects = new UserInfo[] {new UserInfo()};
    // 校验构造函数输入参数是否符合约束
    set2 = executableValidator.validateConstructorParameters(constructor, objects);
  }
}
