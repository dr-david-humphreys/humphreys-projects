package com.lendingcatalog.model;

import com.lendingcatalog.WriteLogToFile;

import java.util.UUID;

public class Tool implements CatalogItem {
    private String id;
    private String type;
    private String manufacturer;
    private int count;

    public Tool(String type, String manufacturer, int count) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getCount() {
        return count;
    }


    @Override
    public boolean matchesName(String searchStr) {
        return type.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        return manufacturer.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return false;
    }

    @Override
    public void registerItem() {
        id = UUID.randomUUID().toString();
        WriteLogToFile.writeLog("Tool created: " + this.toString(), "tool-created-message");
    }

    @Override
    public String toString() {
        return "* " + type + System.lineSeparator()
                + " - Written by: " + manufacturer + System.lineSeparator()
                + " - Count: " + count + System.lineSeparator()
                + " - Id: " + id;
    }
}
