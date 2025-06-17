package com.litmus7.studentdata.dto;

/**
 * represents a student with name,roll no and marks
 */
public class Student {
	private String name;
	private int rollNo;
	private float marks[];

	/**
	 * default constructor
	 * 
	 * Initializes an empty student object
	 */
	public Student() {

	}

	/**
	 * construct a student with specified name,roll no and marks
	 * 
	 * @param name
	 * @param rollNo
	 * @param marks
	 */

	public Student(String name, int rollNo, float marks[]) {
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}

	/**
	 * returns the name of the student
	 * 
	 * @return name of the student
	 */

	public String getName() {

		return name;
	}

	/**
	 * sets the name of the student
	 * 
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns the roll no of the student
	 * 
	 * @return rollNo
	 */

	public int getRollNo() {

		return rollNo;
	}

	/**
	 * sets the roll no of the student
	 * 
	 * @param roll_no
	 */

	public void setRollNo(int roll_no) {
		this.rollNo = roll_no;
	}

	/**
	 * returns the array of marks obtained by the student.
	 * 
	 * @return marks of the student
	 */

	public float[] getMarks() {

		return marks;
	}

	/**
	 * Sets the array of marks for the student.
	 * 
	 * @param marks
	 */
	public void setMarks(float marks[]) {
		this.marks = marks;
	}

}
