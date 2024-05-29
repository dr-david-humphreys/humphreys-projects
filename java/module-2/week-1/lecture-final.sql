--Select 'Intro to Databases';
SELECT 3 + 3 AS totalSum;

SELECT 3 * 8 AS result;

SELECT ABS(3-8) AS absResult;


SELECT customer_id	
FROM customer;

SELECT customer_id, first_name, last_name
FROM customer;

SELECT pizza_id, sale_id, size_id, crust, sauce, price, additional_instructions
FROM pizza
WHERE size_id = 'S'
ORDER BY pizza_id DESC; --ASC is the default

SELECT *
FROM pizza
WHERE size_id = 'S'
ORDER BY pizza_id ASC; --ASC is the default, often omitted

--**D2** not equals - !=
SELECT *
FROM pizza
WHERE size_id != 'S'
ORDER BY pizza_id ASC; --ASC is the default, often omitted

--**D2** Multiple conditions in the WHERE clause
SELECT *
FROM pizza
WHERE size_id = 'S'
AND crust = 'Pan'
ORDER BY pizza_id; --ASC is the default, often omitted 

SELECT *
FROM pizza
WHERE size_id = 'S'
AND crust = 'Pan'
OR crust = 'Thin'
ORDER BY pizza_id; --ASC is the default, often omitted 


--**D2** Multiple ORDER BY columns
SELECT pizza_id, size_id, crust, sauce, price
FROM pizza
WHERE size_id = 'S'
ORDER BY crust ASC, sauce ASC;  --ASC is often omitted

SELECT *
FROM pizza
WHERE size_id = 'S'
AND crust = 'Pan'
OR crust = 'Thin'
ORDER BY crust ASC, sauce DESC; --ASC is often omitted

SELECT pizza_id, size_id, crust, sauce, price
FROM pizza
WHERE size_id = 'S'
ORDER BY crust ASC, sauce ASC, price DESC;  --ASC is often omitted



--**D2** - BETWEEN
SELECT sale_id, is_delivery, customer_id, total
FROM sale
WHERE total > 10 AND total < 20
ORDER BY total;

SELECT sale_id, is_delivery, customer_id, total
FROM sale
WHERE total 
BETWEEN 10 AND 20 --Inclusive
ORDER BY total;


-- IS NULL and IS NOT NULL
SELECT sale_id, total, is_delivery, customer_id
FROM sale
WHERE customer_id IS NULL
ORDER BY sale_id;

SELECT sale_id, total, is_delivery, customer_id
FROM sale
WHERE customer_id IS NOT NULL
ORDER BY sale_id;


-- *** Part one: Queries and Subqueries ***
-- Get customer_id from phone

SELECT customer_id, *
FROM customer
WHERE phone_number = '8734347455';



-- Get sales by using the customer id
SELECT sale_id, total, is_delivery, customer_id
FROM sale
WHERE customer_id = 10;

-- Get sales for customer by phone using subquery
SELECT sale_id, total, is_delivery, customer_id
FROM sale
WHERE customer_id = (
	SELECT customer_id
	FROM customer
	WHERE phone_number = '8734347455'
)


-- Get customer ids for city of Mayport
SELECT customer_id
FROM customer
WHERE city = 'Mayport';


-- Use subquery to get all sales for customers in Mayport
SELECT sale_id, total, is_delivery, customer_id
FROM sale
WHERE customer_id IN (
	SELECT customer_id
	FROM customer
	WHERE city = 'Mayport'
)
ORDER BY sale_id;

-- IN and NOT IN
SELECT sale_id, total, is_delivery, customer_id
FROM sale
WHERE customer_id IN (
	3, 19, 21, 35, 46
)
ORDER BY sale_id;


--**D2** NOT IN
SELECT sale_id, total, is_delivery, customer_id
FROM sale
WHERE customer_id NOT IN (
	3, 19, 21, 35, 46
)
ORDER BY sale_id;


-- *** Part two: Aggregate functions ***

-- Get sum of all sales
SELECT * FROM sale;

SELECT SUM(total) AS total_sales
FROM sale;


-- Get sum of all sales for a customer
SELECT *
FROM sale
WHERE customer_id = 19;

SELECT SUM(total) AS total_sales
FROM sale
WHERE customer_id = 19;

-- Get the smallest, largest, and average sale amount
SELECT MIN(total) AS smallest_sale
FROM sale
WHERE customer_id = 19;

SELECT MAX(total) AS largest_sale
FROM sale
WHERE customer_id = 19;

SELECT AVG(total) AS Average_sales
FROM sale
WHERE customer_id = 19;

-- Round the average sale to 2 decimal places
SELECT ROUND(AVG(total), 2) AS Average_sales
FROM sale
WHERE customer_id = 19;


--**D2**
-- Count the number of pizzas with pineapple
SELECT COUNT(*) AS times_used
    FROM pizza_topping
    WHERE topping_name = 'Pineapple';

-- COUNT(*) vs COUNT using a specific column
SELECT COUNT(*) FROM customer;  -- counts the number of rows 

SELECT COUNT(email_address) FROM customer;  -- counts the number of non null column values



-- *** Part three: GROUP BY ***

-- Get the number of pizzas with each topping
SELECT topping_name, *
FROM pizza_topping;

SELECT topping_name, COUNT(*) AS times_used
FROM pizza_topping
GROUP BY topping_name;



-- Sort them from most frequently used to least
SELECT topping_name, COUNT(*) AS times_used
FROM pizza_topping
GROUP BY topping_name
ORDER BY times_used DESC;


-- *** Part four: String concatenation ***

-- Get all customer names alphabetically by last name
SELECT first_name, last_name
FROM customer
ORDER BY last_name;

-- Concatenate the first and last names with a space between
SELECT first_name || ' ' || last_name AS full_name
FROM customer
ORDER BY last_name;

--differs in how null values are handled, used for more complex concats
SELECT CONCAT(first_name, ' ' , last_name) AS full_name
FROM customer
ORDER BY last_name;

-- LIKE, ILIKE and Wildcards
SELECT customer_id, first_name, last_name
FROM customer
WHERE last_name ILIKE 'd%'; --ILIKE is case insensitive

SELECT customer_id, first_name, last_name
FROM customer
WHERE first_name LIKE '_immy';

SELECT customer_id, first_name, last_name
FROM customer
WHERE first_name LIKE 'J___y';

--**D2**
SELECT customer_id, first_name, last_name
FROM customer
WHERE first_name LIKE 'Jimmy'; -- effectively same as =  ; prefer = 


--**D2** LIMIT
SELECT customer_id, total
FROM sale 
ORDER BY total;

SELECT customer_id, total
FROM sale 
ORDER BY total 
LIMIT 10;


SELECT customer_id, total
FROM sale 
ORDER BY total DESC 
LIMIT 10;

--**D2** Other String Operations 
SELECT LENGTH('You are the One, Neo!');

--SUBSTRING(string FROM start_position FOR length)
SELECT SUBSTRING('You are the One, Neo!' FROM 1 FOR 3); --You
SELECT SUBSTRING('You are the One, Neo!' FROM 18 FOR 21); --Neo!

--REPLACE(string, from_substring, to_substring)
SELECT REPLACE('Welcome to the Matrix!', 'Matrix', 'real world');

--TRIM([LEADING | TRAILING | BOTH] [trim_characters] FROM string)
SELECT '  You are the One, Neo!  ';

SELECT TRIM('  You are the One, Neo!  ');

SELECT TRIM(LEADING FROM '  You are the One, Neo!  ');

SELECT TRIM(TRAILING FROM '  You are the One, Neo!  ');

--Remove specific characters
SELECT TRIM(BOTH '!' FROM '!!!You are the One, Neo!!!');



