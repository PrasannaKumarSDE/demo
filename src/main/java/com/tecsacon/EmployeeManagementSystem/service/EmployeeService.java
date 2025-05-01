package com.tecsacon.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsacon.EmployeeManagementSystem.entity.EmployeeDetails;
import com.tecsacon.EmployeeManagementSystem.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Service

public class EmployeeService implements IEmployeeService {
	
	@Autowired
	EmployeeRepository eRepository;
	
	@Override
	public List<EmployeeDetails> getDetails() {
		
		List<EmployeeDetails> emp_details = eRepository.findAll();
		return emp_details;
	}

	
		@Override
		public EmployeeDetails saveDetails(EmployeeDetails details) {
			return eRepository.save(details);
			
		}
		
 @Override
public EmployeeDetails fetch_empDetails(long id) {
	 return eRepository.findById(id).get();
 }
 
		
 @Override
public EmployeeDetails  save(EmployeeDetails employeedetails) {
	 return eRepository.save(employeedetails);
 }
 
 public EmployeeDetails editDetails(long id) {
	 return eRepository.findById(id).get();
 }
		
   @Override
public EmployeeDetails updateEmployee(long id, EmployeeDetails employeedetails) {
	   EmployeeDetails existingEmployee = editDetails(id);
	   existingEmployee.setId(id);
	   existingEmployee.setFirstName(employeedetails.getFirstName());
	   existingEmployee.setLastName(employeedetails.getLastName());
	   existingEmployee.setEmailId(employeedetails.getEmailId());
       return save(employeedetails);	
	   
   }
   
   @Override
public void deleteEmployeeById (long id) {
	   eRepository.deleteById(id);
	   
   }
 
		
	}

