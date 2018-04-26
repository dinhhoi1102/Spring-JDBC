package com.hoi1102.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hoi1102.model.Employee;
import com.hoi1102.service.EmployeeService;

@Controller
public class HomeController {

	@Autowired
	private EmployeeService employeeService;


	@RequestMapping(value = { "/", "/customer-list"})
	public String listEmployee(Model model) {
		model.addAttribute("listCustomer", employeeService.findAll());
		return "customer-list";
	}

	@RequestMapping(value = "customer-save")
	public String insertEmployee(Model model) {
		model.addAttribute("customer", new Employee());
		return "customer-save";
	}

	@RequestMapping("/customer-view/{id}")
	public String viewEmployee(@PathVariable int id, Model model) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("customer", employee);
		return "customer-view";
	}

	@RequestMapping(value = "customer-update/{id}")
	public String updateEmployee(@PathVariable int id, Model model) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("customer", employee);
		return "customer-update";
	}

	@RequestMapping("/saveCustomer")
	public String doSaveEmployee(@ModelAttribute("Customer") Employee employee, Model model) {
		employeeService.save(employee);
		model.addAttribute("listCustomer", employeeService.findAll());
		return "customer-list";
	}

	@RequestMapping("/updateCustomer")
	public String doUpdateEmployee(@ModelAttribute("Customer") Employee employee, Model model) {
		employeeService.update(employee);
		model.addAttribute("listCustomer", employeeService.findAll());
		return "customer-list";
	}

	@RequestMapping(value = "/delete/{id}")
	public String doDeleteEmployee(@PathVariable int id, Model model) {
		employeeService.delete(id);
		model.addAttribute("listCustomer", employeeService.findAll());
		return "customer-list";
	}

}
