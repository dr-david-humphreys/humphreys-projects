package com.lendingcatalog;

import com.lendingcatalog.model.Book;
import com.lendingcatalog.model.Movie;
import com.lendingcatalog.model.Tool;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    void book_matches_name_exact_match() {
        //Arrange
        Book book = new Book("Jurassic Park", "Michael Crichton", LocalDate.of(1990, 11, 20));

        //Act
        boolean result = book.matchesName("Jurassic Park");

        //Assert
        assertTrue(result);
    }

    @Test
    void book_matches_name_partial_match() {
        //Arrange
        Book book = new Book("Jurassic Park", "Michael Crichton", LocalDate.of(1990, 11, 20));

        //Act
        boolean result = book.matchesName("Park");

        //Assert
        assertTrue(result);
    }

    @Test
    void book_matches_name_case_insensitive() {
        //Arrange
        Book book = new Book("Jurassic Park", "Michael Crichton", LocalDate.of(1990, 11, 20));

        //Act
        boolean result = book.matchesName("jurassic park");

        //Assert
        assertTrue(result);
    }

    @Test
    void movie_matches_name_exact_match() {
        //Arrange
        Movie movie = new Movie("Jurassic Park", "Steven Spielberg", LocalDate.of(1993, 06, 11));

        //Act
        boolean result = movie.matchesName("Jurassic Park");

        //Assert
        assertTrue(result);
    }

    @Test
    void movie_matches_name_partial_match() {
        //Arrange
        Movie movie = new Movie("Jurassic Park", "Steven Spielberg", LocalDate.of(1993, 06, 11));

        //Act
        boolean result = movie.matchesName("Park");

        //Assert
        assertTrue(result);
    }

    @Test
    void movie_matches_name_case_insensitive() {
        //Arrange
        Movie movie = new Movie("Jurassic Park", "Steven Spielberg", LocalDate.of(1993, 06, 11));

        //Act
        boolean result = movie.matchesName("jurassic park");

        //Assert
        assertTrue(result);
    }

    @Test
    void tool_matches_name_exact_match() {
        //Arrange
        Tool tool = new Tool("stapler", "Swingline", 2);

        //Act
        boolean result = tool.matchesName("stapler");

        //Assert
        assertTrue(result);
    }

    @Test
    void tool_matches_name_partial_match() {
        //Arrange
        Tool tool = new Tool("stapler", "Swingline", 2);

        //Act
        boolean result = tool.matchesName("stap");

        //Assert
        assertTrue(result);
    }

    @Test
    void tool_matches_name_case_insensitive() {
        //Arrange
        Tool tool = new Tool("stapler", "Swingline", 2);

        //Act
        boolean result = tool.matchesName("sTapLer");

        //Assert
        assertTrue(result);
    }

    @Test
    void book_matches_creator_name_exact_match() {
        //Arrange
        Book book = new Book("Jurassic Park", "Michael Crichton", LocalDate.of(1990, 11, 20));

        //Act
        boolean result = book.matchesCreator("Michael Crichton");

        //Assert
        assertTrue(result);
    }

    @Test
    void book_matches_creator_name_partial_match() {
        //Arrange
        Book book = new Book("Jurassic Park", "Michael Crichton", LocalDate.of(1990, 11, 20));

        //Act
        boolean result = book.matchesCreator("Crichton");

        //Assert
        assertTrue(result);
    }

    @Test
    void book_matches_creator_name_case_insensitive() {
        //Arrange
        Book book = new Book("Jurassic Park", "Michael Crichton", LocalDate.of(1990, 11, 20));

        //Act
        boolean result = book.matchesCreator("crichton");

        //Assert
        assertTrue(result);
    }

    @Test
    void movie_matches_creator_name_exact_match() {
        //Arrange
        Movie movie = new Movie("Jurassic Park", "Steven Spielberg", LocalDate.of(1993, 06, 11));

        //Act
        boolean result = movie.matchesCreator("Steven Spielberg");

        //Assert
        assertTrue(result);
    }

    @Test
    void movie_matches_creator_name_partial_match() {
        //Arrange
        Movie movie = new Movie("Jurassic Park", "Steven Spielberg", LocalDate.of(1993, 06, 11));

        //Act
        boolean result = movie.matchesCreator("Spielberg");

        //Assert
        assertTrue(result);
    }

    @Test
    void movie_matches_creator_name_case_insensitive() {
        //Arrange
        Movie movie = new Movie("Jurassic Park", "Steven Spielberg", LocalDate.of(1993, 06, 11));

        //Act
        boolean result = movie.matchesCreator("steven spielberg");

        //Assert
        assertTrue(result);
    }

    @Test
    void tool_matches_manufacturer_name_exact_match() {
        //Arrange
        Tool tool = new Tool("stapler", "Swingline", 2);

        //Act
        boolean result = tool.matchesCreator("Swingline");

        //Assert
        assertTrue(result);
    }

    @Test
    void tool_matches_manufacturer_name_partial_match() {
        //Arrange
        Tool tool = new Tool("stapler", "Swingline", 2);

        //Act
        boolean result = tool.matchesCreator("Swing");

        //Assert
        assertTrue(result);
    }

    @Test
    void tool_matches_manufacturer_name_case_insensitive() {
        //Arrange
        Tool tool = new Tool("stapler", "Swingline", 2);

        //Act
        boolean result = tool.matchesCreator("swingline");

        //Assert
        assertTrue(result);
    }

    @Test
    void book_matches_year_exact_match() {
        //Arrange
        Book book = new Book("Jurassic Park", "Michael Crichton", LocalDate.of(1990, 11, 20));

        //Act
        boolean result = book.matchesYear(1990);

        //Assert
        assertTrue(result);
    }

    @Test
    void movie_matches_year_exact_match() {
        //Arrange
        Movie movie = new Movie("Jurassic Park", "Steven Spielberg", LocalDate.of(1993, 06, 11));

        //Act
        boolean result = movie.matchesYear(1993);

        //Assert
        assertTrue(result);
    }
}
