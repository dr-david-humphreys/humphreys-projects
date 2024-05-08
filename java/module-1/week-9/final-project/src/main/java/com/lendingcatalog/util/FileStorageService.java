package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, appendFile))) {
            writer.write(contents);
        } catch (IOException e) {
            throw new FileStorageException(("Error writing to file: " + e.getMessage()));
        }
    }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            throw new FileStorageException(("Error reading from file: " + e.getMessage()));
        }
    }
}
