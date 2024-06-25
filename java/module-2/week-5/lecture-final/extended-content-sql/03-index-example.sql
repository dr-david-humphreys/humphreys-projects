--SQL INDEXES
-- Indexes in PostgreSQL improve the performance of SQL queries by allowing the database to find rows more quickly and efficiently.
-- Note: Collaborative Indexing: In larger organizations, developers typically collaborate with DBAs to implement indexes. 
--       Developers might suggest indexes based on their understanding of application needs, and DBAs can refine these suggestions based on their expertise.

-- Adding 1 million rows to mission table to demonstrate performance gains of an index.  
-- !!!!!!!!WARNING: Dont forget to delete data from the mission table first if you are running the following insert statement multiple times.!!!!!!!!!
INSERT INTO mission (mission_name, launch_date, spacecraft_id)
SELECT
    'Mission ' || i,
    '2023-01-01'::date + (i % 1000),
    (i % 10) + 1
FROM generate_series(1, 1000000) AS s(i);


-- Query Before index 
SELECT * FROM mission WHERE mission_name = 'Mission 600100';
EXPLAIN SELECT * FROM mission WHERE mission_name = 'Mission 600100'; --View the Query Plan Cost=... second number is total cost

--Create the index on the mission table --> mission_name column.  Developers will often work with database admins/engineers to add indexes.
DROP INDEX IF EXISTS idx_mission_name; -- Drop idx_mission_name if already exists
CREATE INDEX idx_mission_name ON mission (mission_name);

-- Query After index 
SELECT * FROM mission WHERE mission_name = 'Mission 600100';
EXPLAIN SELECT * FROM mission WHERE mission_name = 'Mission 600100'; ----View the Query Plan Cost=... second number is total cost

