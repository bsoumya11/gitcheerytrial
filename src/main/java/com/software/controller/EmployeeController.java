package com.software.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.software.dto.EmployeeTaxDetails;
import com.software.entity.EmployeeDetails;
import com.software.repository.EmployeeRepo;
import com.software.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	
	@PostMapping("/emp/save")
	public EmployeeDetails saveEmp(@RequestBody EmployeeDetails emp) {
		EmployeeDetails savedemployee = employeeService.saveEmployee(emp);
		
		return savedemployee;
	}
	/*
	@GetMapping("/tax")
    public ResponseEntity<List<EmployeeTaxDetails>> getEmployeeTaxDetails() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeTaxDetails> employeeTaxResponses = employees.stream().map(employee -> {
            double yearlySalary = employee.getSalary() * 12;
            double tax = taxCalculationService.calculateTax(yearlySalary);
            double cess = taxCalculationService.calculateCess(yearlySalary);
            return new EmployeeTaxResponse(
                    employee.getEmployeeId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    yearlySalary,
                    tax,
                    cess
            );
        }).collect(Collectors.toList());
        return ResponseEntity.ok(employeeTaxResponses);*/
    
	@PostMapping("/taxdetails/{id}")
	public EmployeeTaxDetails txDetail(@RequestBody EmployeeDetails emp,@PathVariable Integer id) {
		//EmployeeTaxDetails emptaxdetail = employeeService.emptaxdetail(emp);
		EmployeeTaxDetails emptaxdetail = employeeService.emptaxdetail(emp, id);
		
		return emptaxdetail;
	}
}
