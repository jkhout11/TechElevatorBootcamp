package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getMovies() {
        String sql = "SELECT * FROM movie";
        return jdbcTemplate.query(sql, movieMapper);
    }

    @Override
    public Movie getMovieById(int id) {
        String sql = "SELECT * FROM movie WHERE movie_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, movieMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        String sql;
        if (useWildCard) {
            title = "%" + title + "%";
            sql = "SELECT * FROM movie WHERE title ILIKE ?";
        } else {
            sql = "SELECT * FROM movie WHERE title = ?";
        }
        return jdbcTemplate.query(sql, movieMapper, title);
    }

    @Override
    public List<Movie> getMoviesByDirectorNameBetweenYears(String directorName, int startYear, int endYear, boolean useWildCard) {
        String sql;
        if (useWildCard) {
            directorName = "%" + directorName + "%";
            sql = "SELECT * FROM movie WHERE director_id IN (SELECT director_id FROM person WHERE person_name ILIKE :directorName) AND release_year BETWEEN :startYear AND :endYear";
        } else {
            sql = "SELECT * FROM movie WHERE director_id IN (SELECT director_id FROM person WHERE person_name = :directorName) AND release_year BETWEEN :startYear AND :endYear";
        }

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("directorName", directorName);
        parameters.addValue("startYear", startYear);
        parameters.addValue("endYear", endYear);

        return namedParameterJdbcTemplate.query(sql, parameters, movieMapper);
    }

    private final RowMapper<Movie> movieMapper = (resultSet, rowNum) -> {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("movie_id"));
        movie.setTitle(resultSet.getString("title"));
        movie.setOverview(resultSet.getString("overview"));
        movie.setTagline(resultSet.getString("tagline"));
        movie.setPosterPath(resultSet.getString("poster_path"));
        movie.setHomePage(resultSet.getString("home_page"));
        movie.setReleaseDate(resultSet.getDate("release_date").toLocalDate());
        movie.setLengthMinutes(resultSet.getInt("length_minutes"));
        movie.setDirectorId(resultSet.getInt("director_id"));
        movie.setCollectionId(resultSet.getInt("collection_id"));
        return movie;
    };
}
