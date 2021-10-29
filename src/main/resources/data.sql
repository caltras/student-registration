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

