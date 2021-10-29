DROP ALL OBJECTS;

ALTER TABLE IF EXISTS registrations DROP CONSTRAINT FK_STUDENT_ID;
ALTER TABLE IF EXISTS registrations DROP CONSTRAINT FK_COURSE_ID;

DROP TABLE IF EXISTS registrations;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS course;

CREATE TABLE student (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    date_of_birthday DATE NOT NULL,
    max_course int DEFAULT 5
);

CREATE TABLE course (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    created_at DATE,
    max_students int DEFAULT 50
);

CREATE TABLE registrations (
    id int AUTO_INCREMENT PRIMARY KEY,
    student_id int,
    course_id int,

    CONSTRAINT FK_STUDENT_ID FOREIGN KEY (student_id) REFERENCES student(id),
    CONSTRAINT FK_COURSE_ID FOREIGN KEY (course_id) REFERENCES course(id)
);
