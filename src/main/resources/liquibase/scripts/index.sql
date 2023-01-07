-- liquibase formatted sql

-- changeset iaberger:1
CREATE INDEX student_index_name ON student(name);

-- changeset iaberger:2
CREATE INDEX faculty_name_color_index ON faculty(name, color);