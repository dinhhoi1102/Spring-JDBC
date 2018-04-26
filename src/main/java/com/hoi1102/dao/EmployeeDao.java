package com.hoi1102.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hoi1102.model.Employee;
import com.hoi1102.model.EmployeeMapper;

@Repository
@Transactional
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Employee employee) {
		String sql = "INSERT INTO employee (name, email) VALUES (?, ?)";
		jdbcTemplate.update(sql, employee.getName(), employee.getEmail());
	}

	public void delete(int id) {
		String sql = "DELETE FROM employee WHERE id = " + id;
		jdbcTemplate.update(sql);
	}

	public void update(Employee employee) {
		String sql = "UPDATE employee SET name = ?, email = ? WHERE id = ? ";
		jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), employee.getId());
	}

	public Employee  findById(int id) {
		String sql = "SELECT * FROM employee WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
	}

	public List<Employee> findAll() {
		String sql = "SELECT * FROM employee";
		return jdbcTemplate.query(sql, new EmployeeMapper());
	}

}
