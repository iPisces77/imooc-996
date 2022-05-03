package com.example.effective.stream.example;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022/5/1
 */
public class CaseThree {
  /** 角色 */
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class Role {
    /** 权限列表 */
    private List<Permission> permissions;
  }
  /** 权限 */
  @Data
  @AllArgsConstructor
  class Permission {
    /** 权限名称 */
    private String name;
  }

  /** 用户角色列表 */
  List<Role> roleList;

  @BeforeEach
  public void init() {
    roleList = new ArrayList();

    Role adminRole = new Role();
    List<Permission> adminPermissionList =
        Lists.newArrayList(new Permission("删除"), new Permission("查看"), new Permission("导出"));
    adminRole.setPermissions(adminPermissionList);

    Role userRole = new Role();
    List<Permission> userPermissionList =
        Lists.newArrayList(
            new Permission("新建"), new Permission("修改"), new Permission("删除"), new Permission("查看"));
    userRole.setPermissions(userPermissionList);

    roleList.add(adminRole);
    roleList.add(userRole);
  }

  @Test
  public void findPermission() {
    roleList.stream()
        .flatMap(role -> role.getPermissions().stream())
        //        .peek(System.out::println)
        .distinct()
        .collect(Collectors.toList())
        .forEach(System.out::println);
  }
}
