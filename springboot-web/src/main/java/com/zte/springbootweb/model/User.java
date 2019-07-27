package com.zte.springbootweb.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class User {
    @NotEmpty(message="姓名不能为空")
    private String name;

    @Max(value = 100, message = "年龄不能大于100岁")
    private int age;

    @NotEmpty(message = "密码不能为空")
    @Length(min=6, message = "密码长度不能小于6位")
    private String pass;
}
