package com.example.effective.valid;

import javax.validation.Valid;

/**
 * @author fuhaixin
 * @date 2022/5/2
 */
public class UserInfoService {
  /** UserInfo作为输入参数 */
  public void setUserInfo(@Valid UserInfo userInfo) {}

  /**
   * UserInfo作为输出参数
   *
   * @return
   */
  public @Valid UserInfo getUserInfo() {
    return new UserInfo();
  }

  public UserInfoService(@Valid UserInfo userInfo) {}

  public UserInfoService() {}
}
