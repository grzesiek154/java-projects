use trainings_notebook;

create table trainings (
id INT AUTO_INCREMENT PRIMARY KEY,
name varchar(50),
type varchar(30),
date date,
exercise_id INT
);

ALTER TABLE trainings change exercise_id exercises_id varchar(50)
ALTER TABLE exerices RENAME TO exercises
ALTER TABLE exercises change duration2 duration INT

create table exerices (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar(50) NOT NULL,
workout_id INT,
description varchar(100),
reps INT,
DURATION INT
);

create table workouts (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar(50) NOT NULL
);

SELECT * FROM trainings
SELECT * FROM exercises

DROP TABLE IF EXISTS exercises