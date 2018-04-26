package com.hoi1102.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoi1102.dao.EmployeeDao;
import com.hoi1102.model.Employee;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	public void save(Employee employee) {
		// validate business
		employeeDao.save(employee);
	}

	public void update(Employee employee) {
		// validate business
		employeeDao.update(employee);
	}

	public void delete(int id) {
		// validate business
		employeeDao.delete(id);
	}
}