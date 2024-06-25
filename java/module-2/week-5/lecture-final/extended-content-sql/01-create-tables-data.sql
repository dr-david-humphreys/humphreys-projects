START TRANSACTION;

DROP TABLE IF EXISTS mission, astronaut, spacecraft CASCADE; --Warning: Use CASCADE with caution. Be sure you know what data is being deleted.

--DDL Statements
CREATE TABLE mission (
    id SERIAL PRIMARY KEY,
    mission_name VARCHAR(100) NOT NULL,
    launch_date DATE NOT NULL,
    spacecraft_id INTEGER NOT NULL
);

CREATE TABLE astronaut (
    id SERIAL PRIMARY KEY,
    astronaut_name VARCHAR(100) NOT NULL,
    mission_id INTEGER NOT NULL,
    FOREIGN KEY (mission_id) REFERENCES mission(id)
);

CREATE TABLE spacecraft (
    id SERIAL PRIMARY KEY,
    spacecraft_name VARCHAR(100) NOT NULL
);



--DML Statements
-- Insert into spacecraft
INSERT INTO spacecraft (spacecraft_name) VALUES
('Apollo 11'), ('Challenger'), ('Discovery');

-- Insert into mission
INSERT INTO mission (mission_name, launch_date, spacecraft_id) VALUES
('Moon Landing', '1969-07-16', 1),
('First Flight', '1983-04-04', 2),
('Hubble Deployment', '1990-04-24', 3);

-- Insert into astronaut
INSERT INTO astronaut (astronaut_name, mission_id) VALUES
('Neil Armstrong', 1), ('Buzz Aldrin', 1), 
('Sally Ride', 2), ('John Glenn', 2),
('Kathryn Sullivan', 3), ('Bruce McCandless', 3);


COMMIT;
