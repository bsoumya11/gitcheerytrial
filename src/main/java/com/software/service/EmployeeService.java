package com.software.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.dto.EmployeeTaxDetails;
import com.software.entity.EmployeeDetails;
import com.software.repository.EmployeeRepo;


@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepo empRepo;

	public EmployeeDetails saveEmployee(EmployeeDetails employee) {

	return	empRepo.save(employee);
	
		
	}
	
	public EmployeeTaxDetails emptaxdetail(EmployeeDetails emp,Integer id) {
		
		//Integer id = emp.getId();
		
		
		EmployeeDetails empDetails = empRepo.findById(id).orElseThrow();
		Double yearlySalary = empDetails.getSalary();
		double tax =0;
		
		 if (yearlySalary > 250000 && yearlySalary <= 500000) {
	            tax += (yearlySalary - 250000) * 0.05;
	        } else if (yearlySalary > 500000 && yearlySalary <= 1000000) {
	            tax += (250000 * 0.05) + ((yearlySalary - 500000) * 0.10);
	        } else if (yearlySalary > 1000000) {
	            tax += (250000 * 0.05) + (500000 * 0.10) + ((yearlySalary - 1000000) * 0.20);
	            
	            
	        }
		 
		double cess = (yearlySalary - 2500000) * 0.02;
		 EmployeeTaxDetails etd= new EmployeeTaxDetails();
		 etd.setId(emp.getId());
		 etd.setTaxAmount(tax);
		 etd.setFirstName(emp.getFirstName());
		 etd.setLastName(emp.getLastName());
		 etd.setCessAmount(cess);
		 
		return etd;
	}
}
