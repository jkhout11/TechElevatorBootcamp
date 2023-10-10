package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {

	private final String DEPARTMENT_SELECT = "SELECT d.department_id, d.name FROM department d ";

	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartmentById(int id) {
		try {
			Department department = null;
			String sql = DEPARTMENT_SELECT + " WHERE d.department_id=?";

			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
			if (results.next()) {
				department = mapRowToDepartment(results);
			}

			if (department == null) {
				throw new DaoException("Department not found for ID: " + id);
			}

			return department;
		} catch (Exception ex) {
			throw new DaoException("Error getting department by ID: " + ex.getMessage(), ex);
		}
	}

	@Override
	public List<Department> getDepartments() {
		try {
			List<Department> departments = new ArrayList<>();
			String sql = DEPARTMENT_SELECT;

			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				departments.add(mapRowToDepartment(results));
			}

			return departments;
		} catch (Exception ex) {
			throw new DaoException("Error getting departments: " + ex.getMessage(), ex);
		}
	}


	@Override
	public Department createDepartment(Department department) {
		String sql = "INSERT INTO department (name) VALUES (?) RETURNING department_id";
		try {
			int newId = jdbcTemplate.queryForObject(sql, Integer.class, department.getName());
			department.setId(newId);
			return department;
		} catch (DataIntegrityViolationException ex) {
			throw new DaoException("Error creating department: " + ex.getMessage(), ex);
		} catch (CannotGetJdbcConnectionException ex) {
			throw new DaoException("Error creating department: unable to connect to the database.", ex);
		}
	}

	@Override
	public Department updateDepartment(Department department) {
		String sql = "UPDATE department SET name=? WHERE department_id=?";
		try {
			jdbcTemplate.update(sql, department.getName(), department.getId());
			return department;
		} catch (DataIntegrityViolationException ex) {
			throw new DaoException("Error updating department: " + ex.getMessage(), ex);
		} catch (CannotGetJdbcConnectionException ex) {
			throw new DaoException("Error updating department: unable to connect to the database.", ex);
		}
	}

	@Override
	public int deleteDepartmentById(int id) {
		String sql = "DELETE FROM department WHERE department_id=?";
		try {
			return jdbcTemplate.update(sql, id);
		} catch (DataIntegrityViolationException ex) {
			throw new DaoException("Error deleting department: " + ex.getMessage(), ex);
		} catch (CannotGetJdbcConnectionException ex) {
			throw new DaoException("Error deleting department: unable to connect to the database.", ex);
		}
	}

	private Department mapRowToDepartment(SqlRowSet results) {
		Department department = new Department();
		department.setId(results.getInt("department_id"));
		department.setName(results.getString("name"));
		return department;
	}

}
