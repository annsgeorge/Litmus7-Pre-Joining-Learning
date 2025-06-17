-- Advisor Table
CREATE TABLE advisor(
advisor_id INT PRIMARY KEY ,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
mail_id VARCHAR(30) UNIQUE,
specialization VARCHAR(100)
);

-- Student Table
CREATE TABLE student(
student_id INT PRIMARY KEY,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
mail_id VARCHAR(40) UNIQUE,
birth_date DATE,
advisor_id INT,
student_status VARCHAR(20) NOT NULL,
FOREIGN KEY(advisor_id) REFERENCES advisor(advisor_id));

-- Course Table
CREATE TABLE course(
course_code INT PRIMARY KEY,
course_title VARCHAR(20) NOT NULL,
course_description VARCHAR(100),
instructor VARCHAR(40));

-- Enrollment Table
CREATE TABLE enrollment(
student_id INT,
course_code INT,
course_status VARCHAR(20) NOT NULL,
PRIMARY KEY(student_id,course_code),
FOREIGN KEY (student_id) REFERENCES student(student_id),
FOREIGN KEY (course_code) REFERENCES course(course_code));






