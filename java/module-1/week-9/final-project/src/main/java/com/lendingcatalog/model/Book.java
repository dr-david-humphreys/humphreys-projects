package com.lendingcatalog.model;

import com.lendingcatalog.WriteLogToFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

public class Book implements CatalogItem {
    private String id;
    private String title;
    private String author;
    private LocalDate publishDate;

    public Book(String title, String author, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }


    @Override
    public boolean matchesName(String searchStr) {
        return title.toLowerCase().contains((searchStr.toLowerCase()));
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        return author.toLowerCase().contains((searchStr.toLowerCase()));
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return publishDate.getYear() == searchYear;
    }

    @Override
    public void registerItem() {
        id = UUID.randomUUID().toString();
        WriteLogToFile.writeLog("Book created: " + this.toString(), "book-created-message.txt");
    }

    @Override
    public String toString() {
        return "* " + title + System.lineSeparator()
                + " - Written by: " + author + System.lineSeparator()
                + " - Published by: " + publishDate + System.lineSeparator()
                + " - Id: " + id;
    }
}
