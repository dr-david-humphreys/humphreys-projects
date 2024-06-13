package com.techelevator.movies.dao;

import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT person_id, person_name FROM person;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            persons.add(mapRowToPerson(results));
        }
        return persons;
    }

    @Override
    public Person getPersonById(int id) {
        String sql = "SELECT person_id, person_name, birthday, deathday, biography, profile_path, home_page FROM person WHERE person_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return mapRowToPerson(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT person_id, person_name, birthday, deathday, biography, profile_path, home_page FROM person WHERE LOWER(person_name) LIKE LOWER(?);";

        if (useWildCard) {
            name = "%" + name + "%";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);

        while (results.next()) {
            persons.add(mapRowToPerson(results));
        }

        return persons;
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT DISTINCT p.person_id, p.person_name, p.birthday " +
                "FROM person p " +
                "JOIN movie_actor ma ON p.person_id = ma.actor_id " +
                "JOIN movie m ON ma.movie_id = m.movie_id " +
                "JOIN collection c ON m.collection_id = c.collection_id " +
                "WHERE LOWER(c.collection_name) LIKE LOWER(?) " +
                "ORDER BY p.person_name;";
        if (useWildCard) {
            collectionName = "%" + collectionName + "%";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionName);

        while (results.next()) {
            persons.add(mapRowToPerson(results));
        }
        return persons;
    }

    private Person mapRowToPerson(SqlRowSet results) {
        Person person = new Person();
        person.setId(results.getInt("person_id"));
        person.setName(results.getString("person_name"));
        person.setBirthday(results.getDate("birthday").toLocalDate());
        if (results.getDate("deathday") != null) {
            person.setDeathDate(results.getDate("deathday").toLocalDate());
        }
        if (results.getString("biography") != null) {
            person.setBiography(results.getString("biography"));
        }
        if (results.getString("profile_path") != null) {
            person.setProfilePath(results.getString("profile_path"));
        }
        if (results.getString("home_page") != null) {
            person.setHomePage(results.getString("home_page"));
        }
        return person;
    }
}
