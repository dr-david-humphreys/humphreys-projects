package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import com.techelevator.movies.model.Movie;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT movie_id, title, director_id FROM movie;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    @Override
    public Movie getMovieById(int id) {
        String sql = "SELECT movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id FROM movie WHERE movie_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return mapRowToMovie(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT movie_id, title FROM movie WHERE LOWER(title) LIKE LOWER(?);";

        if (useWildCard) {
            title = "%" + title + "%";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title);

        while (results.next()) {
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    @Override
    public List<Movie> getMoviesByDirectorNameAndBetweenYears(String directorName, int startYear,
                                                              int endYear, boolean useWildCard) {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT m.movie_id, m.title, m.director_id, p.person_name AS director_name FROM movie m " +
                "JOIN person p ON m.director_id = p.person_id " +
                "Where LOWER (p.person_name) LIKE LOWER(?) " +
                "AND m.release_date BETWEEN ? AND ? " +
                "ORDER BY m.release_date ASC;";

        if (useWildCard) {
            directorName = "%" + directorName + "%";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, directorName, startYear, endYear);

        while (results.next()) {
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    private Movie mapRowToMovie(SqlRowSet results) {
        Movie movie = new Movie();
        movie.setId(results.getInt("movie_id"));
        movie.setTitle(results.getString("title"));
        return movie;
    }
}
