package com.techelevator.movies.dao;

import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        String sql = "SELECT * FROM person";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Person.class));
    }

    @Override
    public Person getPersonById(int id) {
        String sql = "SELECT * FROM person WHERE person_id = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Person.class), id);
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        String sql;
        if (useWildCard) {
            name = "%" + name + "%";
            sql = "SELECT * FROM person WHERE person_name ILIKE ?";
        } else {
            sql = "SELECT * FROM person WHERE person_name = ?";
        }
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Person.class), name);
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        String sql;
        if (useWildCard) {
            collectionName = "%" + collectionName + "%";
            sql = "SELECT DISTINCT person.* FROM person " +
                    "JOIN movie ON person.person_id = movie.director_id " +
                    "JOIN collection ON movie.collection_id = collection.collection_id " +
                    "WHERE collection.collection_name ILIKE ?";
        } else {
            sql = "SELECT DISTINCT person.* FROM person " +
                    "JOIN movie ON person.person_id = movie.director_id " +
                    "JOIN collection ON movie.collection_id = collection.collection_id " +
                    "WHERE collection.collection_name = ?";
        }
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Person.class), collectionName);
    }
}
