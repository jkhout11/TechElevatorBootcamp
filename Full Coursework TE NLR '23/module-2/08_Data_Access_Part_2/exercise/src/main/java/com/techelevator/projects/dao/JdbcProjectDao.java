package com.techelevator.projects.dao;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcProjectDao implements ProjectDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProjectById(int id) {
		Project project = null;
		String sql = "SELECT project_id, name, from_date, to_date " +
				"FROM project " +
				"WHERE project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if (results.next()) {
			project = mapRowToProject(results);
		}
		return project;
	}

	@Override
	public List<Project> getProjects() {
		List<Project> projects = new ArrayList<>();
		String sql = "SELECT project_id, name, from_date, to_date " +
				"FROM project";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Project project = mapRowToProject(results);
			projects.add(project);
		}
		return projects;
	}

	@Override
	public Project createProject(Project project) {
		try {
			String sql = "INSERT INTO project (name, from_date, to_date) " +
					"VALUES (?, ?, ?) " +
					"RETURNING project_id";
			int projectId = jdbcTemplate.queryForObject(sql, Integer.class, project.getName(), project.getFromDate(), project.getToDate());
			project.setId(projectId);
			return project;
		} catch (Exception ex) {
			throw new DaoException("Error creating project", ex);
		}
	}

	@Override
	public void linkProjectEmployee(int projectId, int employeeId) {
		try {
			String sql = "INSERT INTO project_employee (project_id, employee_id) " +
					"VALUES (?, ?)";
			jdbcTemplate.update(sql, projectId, employeeId);
		} catch (Exception ex) {
			throw new DaoException("Error linking project and employee", ex);
		}
	}

	@Override
	public void unlinkProjectEmployee(int projectId, int employeeId) {
		try {
			String sql = "DELETE FROM project_employee " +
					"WHERE project_id = ? " +
					"AND employee_id = ?";
			jdbcTemplate.update(sql, projectId, employeeId);
		} catch (Exception ex) {
			throw new DaoException("Error unlinking project and employee", ex);
		}
	}

	@Override
	public Project updateProject(Project project) {
		try {
			String sql = "UPDATE project " +
					"SET name = ?, from_date = ?, to_date = ? " +
					"WHERE project_id = ?";
			jdbcTemplate.update(sql, project.getName(), project.getFromDate(), project.getToDate(), project.getId());
			return project;
		} catch (Exception ex) {
			throw new DaoException("Error updating project", ex);
		}
	}

	@Override
	public int deleteProjectById(int id) {
		try {
			String sql = "DELETE FROM project_employee WHERE project_id = ?";
			jdbcTemplate.update(sql, id);

			sql = "DELETE FROM project WHERE project_id = ?";
			return jdbcTemplate.update(sql, id);
		} catch (Exception ex) {
			throw new DaoException("Error deleting project", ex);
		}
	}

	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();
		project.setId(rowSet.getInt("project_id"));
		project.setName(rowSet.getString("name"));
		project.setFromDate(rowSet.getDate("from_date").toLocalDate());
		project.setToDate(rowSet.getDate("to_date").toLocalDate());
		return project;
	}
}
