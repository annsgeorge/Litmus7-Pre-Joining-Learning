package com.litmus7.studentdata.dto;

import com.litmus7.studentdata.dto.Student;

/**
 * service class to handle operations related to student like calculating total
 * average,determine grade,printing report card
 */

public class StudentService {
	Student student = new Student();

	/**
	 * calculates total mark of the given student
	 * 
	 * @param student
	 * @return
	 */
	public float getTotal(Student student) {
		float total = 0f;
		for (float n : student.getMarks()) {
			total += n;
		}
		return total;
	}

	/**
	 * calculate the average mark of the given student
	 * 
	 * @param student
	 * @return
	 */

	public float getAverage(Student student) {
		return getTotal(student) / student.getMarks().length;
	}

	/*
	 * enum representing different categories of grade
	 */

	enum Grade {
		A, B, C, D, F
	}

	/**
	 * determines the grade of the student based o average marks
	 * 
	 * @param average
	 * @return
	 */
	public Grade getGrade(float average) {
		if (average >= 90)
			return Grade.A;
		else if (average >= 75)
			return Grade.B;
		else if (average >= 60)
			return Grade.C;
		else if (average >= 50)
			return Grade.D;
		else
			return Grade.F;
	}

	/**
	 * prints the report card of a give student
	 * 
	 * @param student
	 */

	public void printReportCard(Student student) {
		float marks[] = student.getMarks();
		float total = getTotal(student);
		float average = getAverage(student);
		Grade grade = getGrade(average);
		System.out.println("--Report Card--");
		System.out.println("Name : " + student.getName());
		System.out.println("Roll Number : " + student.getRollNo());
		System.out.println("Marks Obtained :");
		for (int i = 0; i < marks.length; i++) {
			System.out.println(" Subject " + (i + 1) + " : " + marks[i]);
		}
		System.out.println("Total Marks : " + total);
		System.out.println("Average Marks : " + average);
		System.out.println("Grade : " + grade + "\n");

	}
}
