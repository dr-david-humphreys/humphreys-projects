# Module Two mid-module project

There are two options for the mid-module project. The two options are:
1. Implement the Solar System Geek Application described below.
2. Create and implement your own application.

The provided Solar System Geek Application is guided with clear requirements describing exactly what work needs to be done.
However, since the application and the instructions were created by Tech Elevator it is a part of the
Tech Elevator curriculum and therefore can not be hosted publicly nor used directly in your software portfolio.

## Creating your own Application

If you decide to create your own application, read the Custom Application Requirements below and **please confirm your Application proposal with your instructor.**

### Custom Application Requirements

The following are the minimum requirements your application must include:
* At least 3 database tables, not including join tables needed to support Many-to-Many relationships.
    * Example 1: school, class, student
    * Example 2: hospital, doctor, patient
    * Example 3: user, artist, song
* Implement the DAO pattern for all tables in the database
    * Each table should have:
      * An interface with abstract methods
      * A class that implements the interface and accesses the database
      * A class to model the data from the database
* A user interface to provide users, in some way, the ability to:
  * Display data from the database
  * Add new data to the database
  * Update data in the database
  * Delete data from the database
* Optional - Integration tests for all DAO implementation classes, e.g. `JdbcCustomerDao`, to verify the methods behave correctly
* A clear purpose, function, or utility

### Datasets and Mock Data

Below are sites that contain free datasets you can use for your application:
* [https://kaggle.com/datasets](https://kaggle.com/datasets)
* [https://ieee-dataport.org](https://ieee-dataport.org)

Below is a site you can use to generate mock SQL data for your application:
* [https://www.mockaroo.com/](https://www.mockaroo.com/)

## Solar System Geek E-Commerce Application

This application allows employees in an e-commerce company to manage customer, product, and sales data. For example, users can view a list of products in the application and then choose to add, update, or delete the product data.

The [Requirements](#requirements) section later in this document describes more fully the application features.

## Database

Before running the application, create the `SSGeek` database. You must match the capitalization shown, or the application won't find the database.

After creating the database, run the `SSGeek.sql` script in the `database` folder to create and populate the database tables. Confirm that the tables exist by opening SSGeek -> Schemas -> Tables. After successfully running the script, you can find the `customer`, `line_item`, `product`, and `sale` tables inside.

Here is the Entity Relationship Diagram (ERD) of the database:

![Database ERD](./database/SSGeek_erd.drawio.png)

## Starting code

Once you have loaded the database, open the Module Two mid-module project in IntelliJ and review the starting code.

The project contains code defining the application's console user interface, including the required DAO interfaces and model classes. The code includes JavaDoc comments to explain the purpose of the various classes and methods.

Review the code provided, focusing on the following classes:

* `Application.java` - The *main* class of the application. Note the `TODO` comment indicating where to replace the `null` values.
* `CustomerDao.java` - The interface for accessing customer data, used by the application's "Customer admin" menu.
* `ProductDao.java` - The interface for accessing product data, used by the application's "Product admin" menu.
* `SaleDao.java` - The interface for accessing the sales data, used by the application's "Sales admin" menu.
* `LineItemDao.java` - The interface for accessing the sale line item details, used by the "Sales admin" menu.

## Requirements

Implement the DAO interfaces (`CustomerDao`, `ProductDao`, `SaleDao`, `LineItemDao`) and update the `Application` class to use them.

### Customer Admin Feature

The application must allow a user to:
* list all customers
* view customer details
* add a customer
* modify customer details

The `CustomerDao` interface provides methods to support these functions.

Create a `JdbcCustomerDao` class to implement this interface, writing tests to verify the methods behave correctly. Then create an instance of the DAO in the `Application` class to make the "Customer admin" menu options functional.

### Product Admin Feature

The application must allow a user to:
* list all products
* view product details
* add a product
* modify product details
* remove a product

The `ProductDao` interface provides methods to support these functions.

Create a `JdbcProductDao` class to implement this interface, writing tests to verify the methods behave correctly. Then create an instance of the DAO in the `Application` class to make the "Product admin" menu options functional.


### Sales Admin Feature

The application must allow a user to:
* list all sales orders for a customer
* list all sales orders for a product
* ship a sales order
* cancel (remove) a sales order

The `SaleDao` interface provides methods to support most of the Sales Admin Features.

Create a `JdbcSaleDao` class to implement this interface, writing tests to verify the methods behave correctly. Then create an instance in the `Application` class to complete the "Sales admin" menu features.

The application must also allow a user to view the details of a sales order.

The `LineItemDao` interface provides methods to support viewing the details of a sales order.

Create a `JdbcLineItemDao` class to implement this interface, writing tests to verify the methods behave correctly. Then create an instance in the `Application` class. Now the application is fully complete.
