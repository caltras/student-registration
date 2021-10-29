ALTER TABLE IF EXISTS registrations DROP CONSTRAINT FK_STUDENT_ID;
ALTER TABLE IF EXISTS registrations DROP CONSTRAINT FK_COURSE_ID;
ALTER TABLE IF EXISTS registrations DROP CONSTRAINT FKCXVEGULU1X4MJCVY3116TU5XU;
ALTER TABLE IF EXISTS registrations DROP CONSTRAINT FKO0IFQ05DGE7SSG2VOQS6WTIK6; 

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


INSERT INTO student values (1, 'Student 1', now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);

INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);

INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);

INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);

INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);
INSERT INTO student values ((SELECT MAX(id) + 1 from student), 'Student '||(SELECT MAX(id) + 1 from student), now(), 5);




INSERT INTO course values (1, 'Course 1', now(), 50);
INSERT INTO course values (2, 'Course 2', now(), 50);
INSERT INTO course values (3, 'Course 3', now(), 50);
INSERT INTO course values (4, 'Course 4', now(), 50);
INSERT INTO course values (5, 'Course 5', now(), 50);
INSERT INTO course values (6, 'Course 6', now(), 50);
INSERT INTO course values (7, 'Course 7', now(), 50);
INSERT INTO course values (8, 'Course 8', now(), 50);
INSERT INTO course values (9, 'Course 9', now(), 50);
INSERT INTO course values (10, 'Course 10', now(), 50);

