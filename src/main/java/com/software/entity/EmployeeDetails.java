package com.software.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data

public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	

	@NotBlank(message = "First Name is mandatory")
	private String firstName;

	@NotBlank(message = "Last Name is mandatory")
	private String lastName;

	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is mandatory")
	private String email;

	@ElementCollection
	@NotEmpty(message = "Phone Number is mandatory")
	private List<@Pattern(regexp = "^[0-9]+$", message = "Phone Number should be valid") String> phoneNumbers;

	@NotBlank(message = "Date of Joining is mandatory")
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date of Joining should be in the format YYYY-MM-DD")
	private String doj;

	@NotNull(message = "Salary is mandatory")
	@Positive(message = "Salary must be positive")
	private Double salary;

}
