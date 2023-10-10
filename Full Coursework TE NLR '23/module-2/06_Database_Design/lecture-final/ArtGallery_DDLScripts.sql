-- DROP DATABASE IF EXISTS "ArtGallery";
-- CREATE DATABASE "ArtGallery";

CREATE TABLE customer
(
	customer_id SERIAL,
	name VARCHAR(150) NOT NULL,
	address VARCHAR(150) NOT NULL,
	phone VARCHAR(11) NULL,
	
	CONSTRAINT pk_customer PRIMARY KEY (customer_id)
	-- add uq constraint phone
);

CREATE TABLE artist
(
	artist_id SERIAL,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	
	CONSTRAINT pk_artist PRIMARY KEY (artist_id)
	
);

CREATE TABLE art
(
	art_code_id SERIAL,
	artist_id INT NOT NULL,
	title VARCHAR(75) NOT NULL, 
	
	CONSTRAINT pk_art PRIMARY KEY (art_code_id)
	--todo add FK	
);

CREATE TABLE customer_purchase
(
	customer_id INT NOT NULL,
	art_code_id INT NOT NULL,
	purchase_date TIMESTAMP NOT NULL,
	price DECIMAL NOT NULL DEFAULT 20, --if no price is supplied it defaults to 20
	
	CONSTRAINT pk_customer_purchase PRIMARY KEY (customer_id, art_code_id, purchase_date)
);

--Alter the tables to add additional constraints
ALTER TABLE customer ADD CONSTRAINT uq_phone UNIQUE (phone);

ALTER TABLE art ADD CONSTRAINT fk_art_artist FOREIGN KEY (artist_id) REFERENCES artist (artist_id);

ALTER TABLE customer_purchase ADD CONSTRAINT chk_customer_purchase_price CHECK (price < 10000000);

ALTER TABLE customer_purchase ALTER COLUMN price SET DEFAULT 50; -- change default after TABLE creation

ALTER TABLE customer_purchase ALTER COLUMN price SET NOT NULL; -- change default after TABLE creation








