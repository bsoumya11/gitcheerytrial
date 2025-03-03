package com.software.dto;

import lombok.Data;

@Data
public class EmployeeTaxDetails {

	//private Integer Id;
	private String firstName;
	private String lastName;
	private double yearlySalary;
	private double taxAmount;
	private double cessAmount;
	

}
