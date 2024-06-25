--SQL VIEWS
-- A view in PostgreSQL is a virtual table that is based on a SELECT query. 
-- It allows you to encapsulate complex queries into a single object that can be treated like a regular table. 
-- Views can simplify your SQL code, enhance security by restricting access to specific data, 
-- and provide a layer of abstraction over your database tables.

DROP VIEW IF EXISTS space_mission_view; 
CREATE VIEW space_mission_view AS
SELECT
	m.mission_name,
	m.launch_date,
	s.spacecraft_name,
	a.astronaut_name
FROM
	mission m
JOIN
   astronaut a ON m.id = a.mission_id
JOIN
	spacecraft s ON m.spacecraft_id = s.id;
	
	
SELECT 
	mission_name,
	launch_date,
	spacecraft_name,
	astronaut_name
FROM
	space_mission_view
WHERE 
	launch_date < '1980-01-01';
	

SELECT 
	mission_name, 
	COUNT(astronaut_name) AS astronaut_count
FROM
	space_mission_view
GROUP BY mission_name;


SELECT * FROM space_mission_view;
