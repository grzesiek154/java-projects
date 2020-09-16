use trainings_notebook;

insert into workouts (name) values("wyrkoki")

ALTER TABLE workouts MODIFY COLUMN  INT auto_increment
ALTER TABLE exerices RENAME TO exercises;
ALTER TABLE exercises RENAME COLUMN DURATION TO duration;
ALTER TABLE exercises ADD type varchar(40) NOT NULL AFTER workout_id;
DELETE FROM workouts WHERE name = "brzuszki";