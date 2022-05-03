package com.example.effective.valid;

import java.util.Optional;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义手机号约束注解关联验证器
 *
 * @author fuhaixin
 * @date 2022/5/2
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

  @Override
  public void initialize(Phone constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // 手机号验证规则:158后头随便
    String check = "158\\d{8}";
    var compile = Pattern.compile(check);
    value = Optional.ofNullable(value).orElse("");
    var matcher = compile.matcher(value);

    return matcher.matches();
  }
}
