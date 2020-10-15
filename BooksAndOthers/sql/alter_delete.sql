use trainings_notebook;

insert into workouts (name) values("wyrkoki")

ALTER TABLE workouts MODIFY COLUMN  INT auto_increment
ALTER TABLE exerices RENAME TO exercises;
ALTER TABLE trainings RENAME COLUMN exercise_id TO exerciseId;
ALTER TABLE exercises ADD type varchar(40) NOT NULL AFTER workout_id;
ALTER TABLE trainings MODIFY exerciseId varchar(50);
DELETE FROM workouts WHERE name = "brzuszki";

