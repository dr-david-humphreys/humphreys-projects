package com.lendingcatalog.model;

import com.lendingcatalog.WriteLogToFile;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class Movie implements CatalogItem {
    private String id;
    private String name;
    private String director;
    private LocalDate releaseDate;

    public Movie(String name, String director, LocalDate releaseDate) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public boolean matchesName(String searchStr) {
        return name.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        return director.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return releaseDate.getYear() == searchYear;
    }

    @Override
    public void registerItem() {
        id = UUID.randomUUID().toString();
        WriteLogToFile.writeLog("Movie created: " + this.toString(), "movie-created-message.txt");
    }

    @Override
    public String toString() {
        return "* " + name + System.lineSeparator()
                + " - Written by: " + director + System.lineSeparator()
                + " - Published by: " + releaseDate + System.lineSeparator()
                + " - Id: " + id;
    }
}
