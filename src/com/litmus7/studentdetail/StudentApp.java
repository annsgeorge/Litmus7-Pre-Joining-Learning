package com.litmus7.studentdetail;

import java.util.Scanner;


import com.litmus7.studentdetails.dto.*;

public class StudentApp {
	


	public static void main(String[] args) {
			
			Student student=new Student();
			Studentservices services=new Studentservices();
			Scanner scanner=new Scanner(System.in);
				
				System.out.println("Enter student name:");
				String name=scanner.nextLine();
				student.setName(name);
				
				System.out.println("Enter Roll Number:");
				int roll_no=scanner.nextInt();
				student.setRollno(roll_no);
				
				System.out.println("Enter marks for 5 subjects:");
				float marks[]=new float[5];
				for(int j=0;j<5;j++) {
					System.out.println("Subject "+ (j+1) +":");
					marks[j]= scanner.nextFloat();
					
					if(marks[j] >100|| marks[j]<0) {
						System.out.println("Invalid");
						j--;
					
					}

				}
				student.setMarks(marks);
				services.printReportcard(student);
				
			         
	}
	
}



