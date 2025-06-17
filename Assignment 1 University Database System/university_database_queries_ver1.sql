-- Advisor Table
CREATE TABLE advisor(
advisor_id INT PRIMARY KEY ,
first_name VARCHAR(70) NOT NULL,
last_name VARCHAR(70) NOT NULL,
mail_id VARCHAR(100) UNIQUE NOT NULL,
specialization VARCHAR(100) NOT NULL
);

-- Student Table
CREATE TABLE student(
student_id INT PRIMARY KEY,
first_name VARCHAR(70) NOT NULL,
last_name VARCHAR(70) NOT NULL,
mail_id VARCHAR(100) UNIQUE NOT NULL,
birth_date DATE NOT NULL,
advisor_id INT,
student_status VARCHAR(20) NOT NULL,
FOREIGN KEY(advisor_id) REFERENCES advisor(advisor_id));

-- Course Table
CREATE TABLE course(
course_id INT PRIMARY KEY,
title VARCHAR(70) NOT NULL,
description VARCHAR(100) NOT NULL,
instructor VARCHAR(70) NOT NULL);

-- Enrollment Table
CREATE TABLE enrollment(
student_id INT,
course_code INT,
status VARCHAR(20) NOT NULL,
enrollment_date DATE NOT NULL,
PRIMARY KEY(student_id,course_code),
FOREIGN KEY (student_id) REFERENCES student(student_id),
FOREIGN KEY (course_code) REFERENCES course(course_code));






