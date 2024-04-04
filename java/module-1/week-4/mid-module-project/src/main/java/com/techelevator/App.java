package com.techelevator;

import java.math.BigDecimal;
import java.util.*;

public class App {

    // The regex string to split the Strings in the dataset.
    private static final String FIELD_DELIMITER = "\\|";

    private static final int TITLE_FIELD = 0;
    private static final int AUTHOR_FIELD = 1;
    private static final int PUBLISHED_YEAR_FIELD = 2;
    private static final int PRICE_FIELD = 3;

    private final Scanner keyboard = new Scanner(System.in);

    private List<String> titles = new ArrayList<>();
    private List<String> authors = new ArrayList<>();
    private List<Integer> publishedYears = new ArrayList<>();
    private List<BigDecimal> prices = new ArrayList<>();

    public static void main(String[] args) {

        App app = new App();
        app.loadData();
        app.run();

    }

    private void loadData() {

        String[] dataset = Dataset.load();

        /*
         Requirement: 1
         Populate the instance variables `titles`, `authors`, `publishedYears`,
         and `prices` by splitting each string in the `dataset` array and adding
         the individual fields to the appropriate list.
         See README for additional details.
         */
        for (String data : dataset) {
            String[] fields = data.split(FIELD_DELIMITER);

            if (fields.length == 4) {
                titles.add(fields[0].trim());
                authors.add(fields[1].trim());
                publishedYears.add(Integer.parseInt(fields[2].trim()));
                prices.add(new BigDecimal(fields[3].trim()));
            }
        }
    }

    private void run() {

        while (true) {
            // Main menu loop
            printMainMenu();
            int mainMenuSelection = promptForMenuSelection("Please choose an option: ");
            if (mainMenuSelection == 1) {
                // Display data and subsets loop
                while (true) {
                    printDataAndSubsetsMenu();
                    int dataAndSubsetsMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (dataAndSubsetsMenuSelection == 1) {
                        displayDataset(Dataset.load());
                    } else if (dataAndSubsetsMenuSelection == 2) {
                        displayTitlesList(titles);
                    } else if (dataAndSubsetsMenuSelection == 3) {
                        displayAuthorsList(authors);
                    } else if (dataAndSubsetsMenuSelection == 4) {
                        displayPublishedYearsList(publishedYears);
                    } else if (dataAndSubsetsMenuSelection == 5) {
                        displayPricesList(prices);
                    } else if (dataAndSubsetsMenuSelection == 0) {
                        break;
                    }
                }
            }
            else if (mainMenuSelection == 2) {
                while (true) {
                    printSearchBooksMenu();
                    int searchBooksMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (searchBooksMenuSelection == 1) {
                        // Search by title
                        String filterTitle = promptForString("Enter title: ");
                        /*
                         Requirement: 3b
                         Replace `displayTitlesList(titles)` with calls to the
                         `filterByTitle()` and `displaySearchResults()` methods.
                         */

                        List<Integer> titleIndexes = filterByTitle(filterTitle);
                        displaySearchResults(titleIndexes, TITLE_FIELD);

                    } else if (searchBooksMenuSelection == 2) {
                        // Search by author
                        String filterAuthor = promptForString("Enter author: ");
                        /*
                         Requirement: 4b
                         Replace `displayAuthorsList(authors)` with calls to the
                         `filterByAuthor()` and `displaySearchResults()` methods.
                         */
                        List<Integer> authorIndexes = filterByAuthor(filterAuthor);
                        displaySearchResults(authorIndexes, AUTHOR_FIELD);

                    } else if (searchBooksMenuSelection == 3) {
                        // Search by published year
                        int filterYear = promptForPublishedYear("Enter date (YYYY): ");
                        /*
                         Requirement: 5b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYear()` and `displaySearchResults()` methods.
                         */
                        List<Integer> publishedYearIndexes = filterByPublishedYear(filterYear);
                        displaySearchResults(publishedYearIndexes, PUBLISHED_YEAR_FIELD);

                    } else if (searchBooksMenuSelection == 4) {
                        // Search by published year range
                        int filterFromYear = promptForPublishedYear("Enter \"from\" date (YYYY): ");
                        int filterToYear = promptForPublishedYear("Enter \"to\" date (YYYY): ");
                        /*
                         Requirement: 6b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYearRange()` and `displaySearchResults()` methods.
                         */
                        List<Integer> publishedYearRange = filterByPublishedYearRange(filterFromYear, filterToYear);
                        displaySearchResults(publishedYearRange, PUBLISHED_YEAR_FIELD);

                    } else if (searchBooksMenuSelection == 5) {
                        // Find the most recent books
                        /*
                         Requirement: 7b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `findMostRecentBooks()` and `displaySearchResults()` methods.
                         */
                        List<Integer> mostRecentBooksIndexes = findMostRecentBooks();
                        displaySearchResults(mostRecentBooksIndexes, TITLE_FIELD);

                    } else if (searchBooksMenuSelection == 6) {
                        // Search by price
                        double filterPrice = promptForPrice("Enter price: ");
                        /*
                         Requirement: 8b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPrice()` and `displaySearchResults()` methods.
                         */
                        List<Integer> priceIndexes = filterByPrice(filterPrice);
                        displaySearchResults(priceIndexes, PRICE_FIELD);

                    } else if (searchBooksMenuSelection == 7) {
                        // Search by price range
                        double filterFromPrice= promptForPrice("Enter \"from\" price: ");
                        double filterToPrice = promptForPrice("Enter \"to\" price: ");
                        /*
                         Requirement: 9b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPriceRange()` and `displaySearchResults()` methods.
                         */
                        List<Integer> priceRangeIndexes = filterByPriceRange(filterFromPrice, filterToPrice);
                        displaySearchResults(priceRangeIndexes, PRICE_FIELD);

                    } else if (searchBooksMenuSelection == 8) {
                        // Find the least expensive books
                        /*
                         Requirement: 10b
                         Replace `displayPricesList(prices)` with calls to the
                         `findLeastExpensiveBooks()` and `displaySearchResults()` methods.
                         */
                        List<Integer> leastExpensiveIndexes = findLeastExpensiveBooks();
                        displaySearchResults(leastExpensiveIndexes, TITLE_FIELD);

                    } else if (searchBooksMenuSelection == 0) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 0) {
                break;
            }
        }

    }

    /*
     Requirement: 2
     Write the displaySearchResults(List<Integer> indexes) method.
     See README for additional details.
     */

    private void displaySearchResults(List<Integer> indexes, int primaryField) {
        if (indexes == null || indexes.isEmpty()) {
            System.out.println("No search results found.");
            return;
        }

        sortSearchResults(indexes, primaryField);

        for (Integer index : indexes) {
            if (index >= 0 && index < titles.size()) {
                String output = "";
                if (primaryField == TITLE_FIELD) {
                    output += "Title: " + titles.get(index) + ": " + authors.get(index) + ": " + publishedYears.get(index) + ": " + prices.get(index);
                } else if (primaryField == AUTHOR_FIELD) {
                    output += "Author: " + authors.get(index) + ": " + titles.get(index) + ": " + publishedYears.get(index) + ": " + prices.get(index);
                } else if (primaryField == PUBLISHED_YEAR_FIELD) {
                    output += "Publication Year: " + publishedYears.get(index) + ": " + titles.get(index) + ": " + authors.get(index) + ": " + prices.get(index);
                } else if (primaryField == PRICE_FIELD) {
                    output += "Price: " + prices.get(index) + ": " + titles.get(index) + ": " + authors.get(index) + ": " + publishedYears.get(index);
                } else {
                    System.out.println("Invalid primary field.");
                    return;
                }
                System.out.println(output);
            } else {
                System.out.println("Invalid index: " + index);
            }
        }
    }

    private void sortSearchResults(List<Integer> indexes, int primaryField) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < indexes.size() - 1; i++) {
                if (compare(indexes.get(i), indexes.get(i + 1), primaryField) > 0) {
                    int temporary = indexes.get(i);
                    indexes.set(i, indexes.get(i + 1));
                    indexes.set(i + 1, temporary);
                    sorted = false;
                }
            }
        }
    }

    private int compare(int index1, int index2, int primaryField) {
        if (primaryField == TITLE_FIELD) {
            return titles.get(index1).compareToIgnoreCase(titles.get(index2));
        } else if (primaryField == AUTHOR_FIELD) {
            return authors.get(index1).compareToIgnoreCase(authors.get(index2));
        } else if (primaryField == PUBLISHED_YEAR_FIELD) {
            return Integer.compare(publishedYears.get(index1), publishedYears.get(index2));
        } else if (primaryField == PRICE_FIELD) {
            return prices.get(index1).compareTo(prices.get(index2));
        } else {
            return 0;
        }
    }

    /*
     Requirement: 3a
     Complete the `filterByTitle()` method.
     See README for additional details.
     */
    private List<Integer> filterByTitle(String filterTitle) {
        List<Integer> searchResults = new ArrayList<>();
        for (int i = 0; i <titles.size(); i++) {
            String title = titles.get(i);
            if (title.toLowerCase().contains(filterTitle.toLowerCase(Locale.ROOT))) {
                searchResults.add(i);
            }
        }
        return searchResults;
    }

    /*
     Requirement: 4a
     Complete the `filterByAuthor()` method.
     See README for additional details.
     */
    private List<Integer> filterByAuthor(String filterAuthor) {
        List<Integer> searchResults = new ArrayList<>();
        for (int i = 0; i < authors.size(); i++) {
            String author = authors.get(i);
            if (author.toLowerCase().contains(filterAuthor.toLowerCase(Locale.ROOT))) {
                searchResults.add(i);
            }
        }
        return searchResults;
    }

    /*
     Requirement: 5a
     Complete the `filterByPublishedYear()` method.
     See README for additional details.
     */
    private List<Integer> filterByPublishedYear(int filterYear) {
        List<Integer> searchResults = new ArrayList<>();
        for (int i = 0; i < publishedYears.size(); i++) {
            int publishedYear = publishedYears.get(i);
            if (publishedYear == filterYear) {
                searchResults.add(i);
            }
        }
        return searchResults;
    }

    /*
     Requirement: 6a
     Complete the `filterByPublishedYearRange()` method.
     See README for additional details.
     */
    private List<Integer> filterByPublishedYearRange(int filterFromYear, int filterToYear) {
        List<Integer> searchResults = new ArrayList<>();
        for (int i = 0; i < publishedYears.size(); i++) {
            int publishedYear = publishedYears.get(i);
            if (publishedYear >= filterFromYear && publishedYear <= filterToYear) {
                searchResults.add(i);
            }
        }
        return searchResults;
    }

    /*
     Requirement: 7a
     Add the `private List<Integer> findMostRecentBooks()` method.
     See README for additional details.
     */

    private List<Integer> findMostRecentBooks() {
        List<Integer> searchResults = new ArrayList<>();

        int latestYear = Integer.MIN_VALUE;
        for (int year : publishedYears) {
            if (year > latestYear) {
                latestYear = year;
            }
        }
        for (int i = 0; i < publishedYears.size(); i++) {
            if (publishedYears.get(i) == latestYear) {
                searchResults.add(i);
            }
        }
        return searchResults;
    }

    /*
     Requirement: 8a
     Complete the `filterByPrice()` method.
     See README for additional details.
     */
    private List<Integer> filterByPrice(double filterPrice) {
        List<Integer> searchResults = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            BigDecimal price = prices.get(i);
            if (price.doubleValue() == filterPrice) {
                searchResults.add(i);
            }
        }
        return searchResults;
    }

    /*
     Requirement: 9a
     Complete the `filterByPriceRange()` method.
     See README for additional details.
     */
    private List<Integer> filterByPriceRange(double filterFromPrice, double filterToPrice) {
        List<Integer> searchResults = new ArrayList<>();

        for (int i = 0; i < prices.size(); i++) {
            BigDecimal price = prices.get(i);
            double priceValue = price.doubleValue();

            if (priceValue >= filterFromPrice && priceValue <= filterToPrice) {
                searchResults.add(i);
            }
        }
        return searchResults;
    }

    /*
     Requirement: 10a
     Add the `private List<Integer> findLeastExpensiveBooks()` method.
     See README for additional details.
     */

    private List<Integer> findLeastExpensiveBooks() {
        BigDecimal lowestPrice = prices.get(0);
        List<Integer> leastExpensiveIndexes = new ArrayList<>();

        // find lowest price
        for (int i = 1; i < prices.size(); i++) {
            BigDecimal price = prices.get(i);
            if (price.compareTo(lowestPrice) < 0) {
                lowestPrice = price;
            }
        }

        // find index of book with lowest price
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).compareTo(lowestPrice) == 0) {
                leastExpensiveIndexes.add(i);
            }
        }

        return leastExpensiveIndexes;
    }


    // UI methods

    private void printMainMenu() {
        System.out.println("1: Display data and subsets");
        System.out.println("2: Search books");
        System.out.println("0: Exit");
        System.out.println();
    }

    private void printDataAndSubsetsMenu() {
        System.out.println("1: Display dataset");
        System.out.println("2: Display titles");
        System.out.println("3: Display authors");
        System.out.println("4: Display published years");
        System.out.println("5: Display prices");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void printSearchBooksMenu() {
        System.out.println("1: Search by title");
        System.out.println("2: Search by author");
        System.out.println("3: Search by published year");
        System.out.println("4: Search by published year range");
        System.out.println("5: Find most recent books");
        System.out.println("6: Search by price");
        System.out.println("7: Search by price range");
        System.out.println("8: Find least expensive books");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void displayDataset(String[] dataset) {
        System.out.println("Dataset");
        System.out.println("-------");
        for (String data : dataset) {
            System.out.println(data);
        }
        System.out.println();
        promptForReturn();
    }

    private void displayTitlesList(List<String> titles) {
        System.out.println("Titles");
        System.out.println("-------");
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(i + ": " + titles.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayAuthorsList(List<String> authors) {
        System.out.println("Authors");
        System.out.println("-------");
        for (int i = 0; i < authors.size(); i++) {
            System.out.println(i + ": " + authors.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayPublishedYearsList(List<Integer> publishedYears) {
        System.out.println("Published Years");
        System.out.println("---------------");
        for (int i = 0; i < publishedYears.size(); i++) {
            System.out.println(i + ": " + publishedYears.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayPricesList(List<BigDecimal> prices) {
        System.out.println("Prices");
        System.out.println("------");
        for (int i = 0; i < prices.size(); i++) {
            System.out.println(i + ": " + prices.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private int promptForMenuSelection(String prompt) {
        System.out.print(prompt);
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    private String promptForString(String prompt) {
        System.out.print(prompt);
        return keyboard.nextLine();
    }

    private int promptForPublishedYear(String prompt) {
        int year;
        while (true) {
            System.out.println(prompt);
            try {
                year = Integer.parseInt(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The year provided is not well-formed. It must be YYYY.");
            }
        }
        return year;
    }

    private double promptForPrice(String prompt) {
        double price;
        while (true) {
            System.out.println(prompt);
            try {
                price = Double.parseDouble(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The price provided is not a valid monetary value.");
            }
        }
        return price;
    }

    private void promptForReturn() {
        System.out.println("Press RETURN to continue.");
        keyboard.nextLine();
    }
}
