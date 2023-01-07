ALTER table student
add constraint age_constraint check ( age > 16 );

ALTER table student
add constraint name_unique unique (name);

ALTER table student
alter column name set not null;

ALTER table student
add constraint name_and_color_unique unique (name, color);

ALTER table student
alter column age set default 20;

