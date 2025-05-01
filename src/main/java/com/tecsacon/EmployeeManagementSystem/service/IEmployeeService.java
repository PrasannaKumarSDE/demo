package com.tecsacon.EmployeeManagementSystem.service;

import java.util.List;

import com.tecsacon.EmployeeManagementSystem.entity.EmployeeDetails;

public interface IEmployeeService {

	List<EmployeeDetails> getDetails();

	EmployeeDetails saveDetails(EmployeeDetails details);

	EmployeeDetails fetch_empDetails(long id);

	EmployeeDetails save(EmployeeDetails employeedetails);

	EmployeeDetails updateEmployee(long id, EmployeeDetails employeedetails);

	void deleteEmployeeById(long id);

}