package com.example.effective.valid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
// 自定义注解作用目标
@Target(ElementType.FIELD)
// 注解的保留策略
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {
  // 约束注解验证时端输出信息
  String message() default "手机号验证错误";
  // 约束注解在验证时,所属的组别
  Class<?>[] groups() default {};
  // 约束注解的有效负载
  Class<? extends Payload>[] payload() default {};
}
