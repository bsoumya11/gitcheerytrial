package com.software.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.software.entity.EmployeeDetails;
@Repository
public interface EmployeeRepo extends CrudRepository<EmployeeDetails, Integer>{

}
