package com.mannai.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record EmployeeReq(

		@NotBlank(message = "name shouldn't be NULL OR EMPTY")
		String name,

		String department,

		@Min(value = 1, message = "salary can't be less than 0")
		@Positive(message = "Salary must be a positive number")
		Double salary) {
}
