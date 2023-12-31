-- SELECT
-- Use a SELECT statement to return a literal string
SELECT 'Hello World!';


-- Use a SELECT statement to add two numbers together (and label the result "sum")
SELECT 5 + 5 AS sum;


-- SELECT ... FROM
-- Write queries to retrieve...

-- The names from all the records in the state table
SELECT state_name
FROM state;


-- The names and populations of all cities
SELECT city_name, population
FROM city;

-- All columns from the park table
SELECT * FROM park;


-- SELECT __ FROM __ WHERE
-- Write queries to retrieve...

-- The names of cities in California (CA)
SELECT 
	city_name
FROM 
	city
WHERE 
	state_abbreviation = 'CA';

-- The names and state abbreviations of cities NOT in California
SELECT
	city_name
FROM
	city
WHERE 
	state_abbreviation <> 'CA';


-- The names and areas of cities smaller than 25 square kilometers 
SELECT * FROM city; -- SEE WHAT THE DATA LOOKS LIKE

SELECT
	--COLUMNS NAMES (S)
	city_name,
	area
FROM 
	city --TABLE(S)
WHERE
	area < 25; --LIMITS/FILTERS ROWS RETURNED

-- The names from all records in the state table that have no assigned census region
SELECT * FROM state; --discovery
SELECT
	state_name,
	census_region
FROM
	state
WHERE
	census_region IS NULL;


-- The names and census regions from all records in the state table that have an assigned census region
SELECT
	state_name,
	census_region
FROM 
	state
WHERE
	census_region <> 'null';


-- WHERE with AND/OR
-- Write queries to retrieve...

-- The names, areas, and populations of cities smaller than 25 sq. km. with more than 100,000 people
SELECT * FROM city; --discovery
SELECT
	city_name,
	area,
	population
FROM
	city
WHERE
	area < 25
AND
	population > 100000;

-- The names and census regions of all states (and territories and districts) not in the Midwest region (including those that don't have any census region)
SELECT * FROM state; --discovery

SELECT
	state_name,
	census_region
FROM
	state
WHERE
	census_region <> 'Midwest' OR census_region IS NULL;

-- The names, areas, and populations of cities in California (CA) or Florida (FL)
SELECT * FROM city;

SELECT
	city_name
	area,
	population
FROM
	city
WHERE
	state_abbreviation = 'CA' OR state_abbreviation = 'FL';	


-- The names, areas, and populations of cities in New England -- Connecticut (CT), Maine (ME), Massachusetts (MA), New Hampshire (NH), Rhode Island (RI) and Vermont (VT)
SELECT * FROM city;

SELECT
	city_name,
	area,
	population
FROM
	city
WHERE
	state_abbreviation IN ('CT', 'ME', 'MA', 'NH', 'RI', 'VT');

-- SELECT statements involving math
-- Write a query to retrieve the names and areas of all parks in square METERS
-- (the values in the database are stored in square kilometers)
-- Label the second column "area_in_square_meters"
SELECT
	park_name,
	area
FROM
	park;
--==============================	
SELECT
	park_name,
	(area * 1000000) AS area_in_square_meters
FROM
	park;	


-- All values vs. distinct values

-- Write a query to retrieve the names of all cities and notice repeats (like Springfield and Columbus)


-- Do it again, but without the repeats (note the difference in row count)
SELECT DISTINCT
	city_name
FROM
	city;


-- LIKE
-- Write queries to retrieve...

-- The names of all cities that begin with the letter "A"
SELECT
	city_name
FROM
	city
WHERE
	city_name LIKE 'A%'; 

-- The names of all cities that end with "Falls"
SELECT
	city_name
FROM
	city
WHERE
	city_name LIKE '%Falls';

-- The names of all cities that contain a space
SELECT
	city_name
FROM
	city
WHERE
	city_name LIKE '% %';


-- BETWEEN
-- Write a query to retrieve the names and areas of parks of at least 100 sq. kilometers but no more than 200 sq. kilometers
SELECT
	park_name,
	area
FROM
	park
WHERE
	area BETWEEN 100 AND 200;


-- DATES
-- Write a query to retrieve the names and dates established of parks established before 1900
SELECT * FROM park; --discovery

SELECT
	park_name,
	date_established
FROM 
	park
WHERE
	date_established < '1/1/1900';
	
--1. The name, state abbreviation, and population of cities with a population greater than 1,000,000 people (10 rows)

SELECT
	city_name,
	state_abbreviation,
	population
FROM
	city
WHERE
	population < 1000000;
	



--2. The name, population, and sales tax of all records in the state table with a sales tax of at least 7% or have a population of less than 1,000,000 (17 rows)

SELECT
	state_name,
	population,
	sales_tax
FROM 
	state
WHERE
	sales_tax >= 7.000 OR population < 1000000
	

