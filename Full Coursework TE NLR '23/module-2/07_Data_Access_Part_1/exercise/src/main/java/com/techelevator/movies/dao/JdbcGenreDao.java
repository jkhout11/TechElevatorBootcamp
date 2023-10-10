package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import javax.sql.DataSource;
import java.util.List;

public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Genre> getGenres() {
        String sql = "SELECT genre_id, genre_name FROM genre";
        return jdbcTemplate.query(sql, genreMapper);
    }

    @Override
    public Genre getGenreById(int id) {
        String sql = "SELECT genre_id, genre_name FROM genre WHERE genre_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, genreMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null; // Return null when no genre is found
        }
    }

    @Override
    public List<Genre> getGenresByName(String name, boolean useWildCard) {
        String sql;
        if (useWildCard) {
            name = "%" + name + "%";
            sql = "SELECT genre_id, genre_name FROM genre WHERE genre_name ILIKE ?";
        } else {
            sql = "SELECT genre_id, genre_name FROM genre WHERE genre_name = ?";
        }
        return jdbcTemplate.query(sql, genreMapper, name);
    }

    private final RowMapper<Genre> genreMapper = (resultSet, rowNum) -> {
        Genre genre = new Genre();
        genre.setId(resultSet.getInt("genre_id"));
        genre.setName(resultSet.getString("genre_name"));
        return genre;
    };
}
