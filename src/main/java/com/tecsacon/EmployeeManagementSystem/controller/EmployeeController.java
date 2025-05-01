package com.tecsacon.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tecsacon.EmployeeManagementSystem.entity.EmployeeDetails;
import com.tecsacon.EmployeeManagementSystem.service.IEmployeeService;

import jakarta.validation.Valid;

@Controller

public class EmployeeController {
	
	@Autowired
	IEmployeeService eservice;
	
	//Getting All the Employee Details and Displaying
	@GetMapping("/")
	//@ResponseBody
	public String get(Model model) {
		List<EmployeeDetails> emp_details1 = eservice.getDetails();
		model.addAttribute("employees", emp_details1);
		return "employees"; // ---> is the HTML form in the template folder
		
		
	}
	
	//When clicking on add button it have to move to create_employee.html
@GetMapping("/employees/new")
public String newDetails(Model model) {
	EmployeeDetails employeeDetails = new EmployeeDetails();
	model.addAttribute("employee", employeeDetails);
	return "create_employee";
	
}


//adding the data
   @PostMapping("/employees")
   public String save(@Valid
		    @ModelAttribute("employee") EmployeeDetails details,
		    BindingResult result) {
	   if (result.hasErrors()) {
		   return "create_employee";
	   }
	   eservice.saveDetails(details);
	   return "redirect:/";
	   
	   
   }
   //rendering the edit_employee.html view
   
   @GetMapping("/employees/edit/{id}")
   public String edit_view(@PathVariable long id,Model model ) {
	   model.addAttribute("employee", eservice.fetch_empDetails(id));
	   return "edit_employee";
   }
   
    

   //updating the details;
  // @PostMapping("/employees/{id}")
   
   @PostMapping("/employees/{id}")
   public String updateDetails(@PathVariable long id,
   @Valid @ModelAttribute("employee") EmployeeDetails employeedetails,
   BindingResult result) {
	   if(result.hasErrors()) {
		   return "edit_employee";
		   
	   }
	   eservice.updateEmployee(id, employeedetails);
	   return "redirect:/";
   }
   //deleting the record;
   
   @GetMapping("/employee/{id}")
   public String deleteDetails (@PathVariable long id,
		   @Valid @ModelAttribute("employee") EmployeeDetails employeedetails,
		   BindingResult result) {
	   if (result.hasErrors()) {
		   return "edit_employee";
		   
	   }
	   eservice.deleteEmployeeById(id);
	   return "redirect:/";
   }
   
   
   
  /* @GetMapping("/employee/{id}")
   public String delete (@PathVariable long id ) {
	   eservice.deleteEmployeeById(id);
	   return "redirect:/";
   }
   */
   
   







}
