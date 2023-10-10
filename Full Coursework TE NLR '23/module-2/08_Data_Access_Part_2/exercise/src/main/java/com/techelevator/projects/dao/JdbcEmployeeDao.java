package com.techelevator.projects.dao;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeDao implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"FROM employee " +
				"WHERE employee_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if (results.next()) {
			employee = mapRowToEmployee(results);
		}
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"FROM employee";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByFirstNameLastName(String firstName, String lastName) {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"FROM employee " +
				"WHERE (first_name ILIKE ? OR ? IS NULL) AND (last_name ILIKE ? OR ? IS NULL)";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstName + "%", firstName, "%" + lastName + "%", lastName);
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT e.employee_id, e.department_id, e.first_name, e.last_name, e.birth_date, e.hire_date " +
				"FROM employee e " +
				"JOIN project_employee pe ON e.employee_id = pe.employee_id " +
				"WHERE pe.project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"FROM employee " +
				"WHERE employee_id NOT IN (SELECT DISTINCT employee_id FROM project_employee)";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		String sql = "INSERT INTO employee (department_id, first_name, last_name, birth_date, hire_date) " +
				"VALUES (?, ?, ?, ?, ?)";
		try {
			jdbcTemplate.update(sql, employee.getDepartmentId(), employee.getFirstName(), employee.getLastName(),
					employee.getBirthDate(), employee.getHireDate());
		} catch (DataAccessException e) {
			throw new DaoException("Error creating employee", e);
		}
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		String sql = "UPDATE employee " +
				"SET department_id = ?, first_name = ?, last_name = ?, birth_date = ?, hire_date = ? " +
				"WHERE employee_id = ?";
		try {
			jdbcTemplate.update(sql, employee.getDepartmentId(), employee.getFirstName(), employee.getLastName(),
					employee.getBirthDate(), employee.getHireDate(), employee.getId());
		} catch (DataAccessException e) {
			throw new DaoException("Error updating employee", e);
		}
		return employee;
	}

	@Override
	public int deleteEmployeeById(int id) {
		try {
			String sql = "DELETE FROM project_employee WHERE employee_id = ?";
			jdbcTemplate.update(sql, id);

			sql = "DELETE FROM employee WHERE employee_id = ?";
			return jdbcTemplate.update(sql, id);
		} catch (DataAccessException e) {
			throw new DaoException("Error deleting employee", e);
		}
	}


	@Override
	public int deleteEmployeesByDepartmentId(int departmentId) {
		String sql = "DELETE FROM project_employee WHERE employee_id IN (SELECT employee_id FROM employee WHERE department_id = ?)";
		jdbcTemplate.update(sql, departmentId);

		sql = "DELETE FROM employee WHERE department_id = ?";
		return jdbcTemplate.update(sql, departmentId);
	}

	private Employee mapRowToEmployee(SqlRowSet rowSet) {
		Employee employee = new Employee();
		employee.setId(rowSet.getInt("employee_id"));
		employee.setDepartmentId(rowSet.getInt("department_id"));
		employee.setFirstName(rowSet.getString("first_name"));
		employee.setLastName(rowSet.getString("last_name"));
		employee.setBirthDate(rowSet.getDate("birth_date").toLocalDate());
		employee.setHireDate(rowSet.getDate("hire_date").toLocalDate());
		return employee;
	}
}
