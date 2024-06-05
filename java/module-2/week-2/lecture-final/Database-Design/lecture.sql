--CREATE DATABASE artgallery;
START TRANSACTION;


DROP TABLE IF EXISTS customer_purchase, art, artist, customer;

CREATE TABLE customer
(
	customer_id SERIAL,
	name VARCHAR(75) NOT NULL,
	address VARCHAR(100) NOT NULL,
	phone VARCHAR(11) NULL,
	
	CONSTRAINT pk_customer PRIMARY KEY (customer_id)

);

CREATE TABLE artist
(
	artist_id SERIAL,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	
	CONSTRAINT pk_artist PRIMARY KEY(artist_id)

);

CREATE TABLE art
(
	art_code_id serial,
	title VARCHAR(100) NOT NULL,
	artist_id INT,
	
	CONSTRAINT pk_art PRIMARY KEY(art_code_id),
	CONSTRAINT fk_art_artist FOREIGN KEY (artist_id) REFERENCES artist(artist_id)

);

CREATE TABLE customer_purchase
(
	customer_id INT NOT NULL,
	art_code_id INT NOT NULL,
	purchase_date DATE NOT NULL, 
	price MONEY NOT NULL, DEFAULT 20, --if no price is supplied it defaults to 20; used for handling currency where 2 decimal places is sufficient.
	--price DECIMAL NOT NULL DEFAULT 20, --if no price is supplied it defaults to 20; can be used for a wide range of numeric values; can control precision
	
	CONSTRAINT pk_customer_purchase PRIMARY KEY (customer_id, art_code_id, purchase_date),
	CONSTRAINT fk_customer_purchase_customer FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
	CONSTRAINT fk_customer_purchate_art FOREIGN KEY (art_code_id) REFERENCES art(art_code_id)

);



--Alter the tables to add additional constraints
ALTER TABLE customer ADD CONSTRAINT uq_phone UNIQUE (phone);

--ALTER TABLE art ADD CONSTRAINT fk_art_artist FOREIGN KEY (artist_id) REFERENCES artist (artist_id);

ALTER TABLE customer_purchase ADD CONSTRAINT chk_customer_purchase_price CHECK (price < CAST(10000000 AS MONEY));
--ALTER TABLE customer_purchase ADD CONSTRAINT chk_customer_purchase_price CHECK (price < 10000000); --for data type DECIMAL

ALTER TABLE customer_purchase ALTER COLUMN price SET DEFAULT 50; -- change default after TABLE creation

ALTER TABLE customer_purchase ALTER COLUMN price SET NOT NULL; -- change default after TABLE creation


--Alter tables to remove constraints
--ALTER TABLE table_name DROP CONSTRAINT constraint_name;
ALTER TABLE customer_purchase DROP CONSTRAINT chk_customer_purchase_price;

COMMIT TRANSACTION;