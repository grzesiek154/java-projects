use trainings_notebook;

insert into workouts (name) values("wyrkoki")

ALTER TABLE workouts MODIFY COLUMN id INT auto_increment

DELETE FROM workouts WHERE name = "brzuszki";