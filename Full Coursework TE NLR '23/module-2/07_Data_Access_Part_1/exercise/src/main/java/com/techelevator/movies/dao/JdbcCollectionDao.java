package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {
        String sql = "SELECT * FROM collection";
        return jdbcTemplate.query(sql, collectionMapper);
    }

    @Override
    public Collection getCollectionById(int id) {
        String sql = "SELECT * FROM collection WHERE collection_id = ?";
        return jdbcTemplate.queryForObject(sql, collectionMapper, id);
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        String sql;
        if (useWildCard) {
            name = "%" + name + "%";
            sql = "SELECT * FROM collection WHERE collection_name ILIKE ?";
        } else {
            sql = "SELECT * FROM collection WHERE collection_name = ?";
        }
        return jdbcTemplate.query(sql, collectionMapper, name);
    }

    private final RowMapper<Collection> collectionMapper = (resultSet, rowNum) -> {
        Collection collection = new Collection();
        collection.setId(resultSet.getInt("collection_id"));
        collection.setName(resultSet.getString("collection_name"));
        return collection;
    };
}
