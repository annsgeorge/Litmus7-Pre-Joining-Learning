package com.litmus7.studentdetail;

import com.litmus7.studentdetails.dto.Student;

public class Studentservices {
		Student student=new Student();

	public float getTotal(Student student ) {
		float total=0f;
		for(float n:student.getMarks()){
			total+=n;
		}
		return total;
	}
	public float getAverage(Student student) {
		return getTotal(student)/student.getMarks().length;
	}
	
	public char getGrade(float average) {
		if(average >=90)
			return 'A';
		else if(average >= 75)
			return 'B';
		else if(average >= 60)
			return 	'C';
		else if(average >= 50)
			return 'D';
		else
			return 'F';
}

	 public void printReportcard(Student student) {
		 float total = getTotal(student);
	     float average = getAverage(student);
	     char grade = getGrade(average);
		 System.out.println("--Report Card--");
		 System.out.println("Name : " + student.getName());
		 System.out.println("Roll Number : " + student.getRollno());
		 
		 System.out.println("Total Marks : " + total );
		 average=total/5;
		 System.out.println("Average Marks : " + average);
		 System.out.println("Grade : " + grade);	 
		 
}
}

