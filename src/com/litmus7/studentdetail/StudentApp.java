package com.litmus7.studentdetail;

import java.util.Scanner;

import com.litmus7.studentdetails.dto.*;

/**
 * The main application class to interact with the user and generate a students
 * report card
 */
public class StudentApp {
	/**
	 * Collects student details from user ,validates it and print the report card
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		StudentService services = new StudentService();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of students :");
		int numberOfStudents = scanner.nextInt();
		scanner.nextLine();

		Student student[] = new Student[numberOfStudents];
		for (int i = 0; i < numberOfStudents; i++) {
			student[i] = new Student();
			System.out.println("Student : " + (i + 1));
			System.out.println("Enter student name:");
			String name = scanner.nextLine();
			student[i].setName(name);

			System.out.println("Enter Roll Number:");
			int rollNo = scanner.nextInt();
			student[i].setRollNo(rollNo);

			System.out.println("Enter marks for 5 subjects:");
			float marks[] = new float[5];
			for (int j = 0; j < 5; j++) {
				System.out.println("Subject " + (j + 1) + ":");
				marks[j] = scanner.nextFloat();

				if (marks[j] > 100 || marks[j] < 0) {
					System.out.println("Invalid");
					j--;

				}

			}
			scanner.nextLine();
			student[i].setMarks(marks);
			services.printReportCard(student[i]);

		}
	}
}
