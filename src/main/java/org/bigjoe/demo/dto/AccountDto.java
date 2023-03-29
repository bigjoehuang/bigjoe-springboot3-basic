package org.bigjoe.demo.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class AccountDto {
	@NotBlank(message = "名称不能为空")
	private String name;

    @NotNull(message = "accountId不能为空")
 	@Range(message = "必须在{min}-{max}之间", min = 100, max = 9999999)
	private Integer accountId;
	
}
