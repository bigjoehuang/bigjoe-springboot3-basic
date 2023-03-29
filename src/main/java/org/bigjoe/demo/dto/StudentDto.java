package org.bigjoe.demo.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

public class StudentDto {
	@NotBlank(message = "姓名不能为空")
	@Length(min = 6, max = 20, message = "长度不符")
	private String name;

	@Min(value = 18, message = "年龄不能小于18岁")
	private Integer age;

	@Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号格式错误")
	private String phone;

	@Email(message = "邮箱格式错误")
	private String email;

	@Valid
	private School school;

	@Data
	private static class School {
		@NotBlank(message = "学校名不能为空")
		private String name;

		@NotBlank(message = "学校地址不能为空")
		private String address;
	}
}
