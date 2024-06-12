package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT * FROM collection;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            collections.add(mapRowToCollection(results));
        }
        return collections;
    }

    @Override
    public Collection getCollectionById(int id) {
        return new Collection(-1, "Not implemented yet");
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        return null;
    }

    private Collection mapRowToCollection(SqlRowSet results) {
        Collection collection = new Collection();
        return collection;
    }
}
