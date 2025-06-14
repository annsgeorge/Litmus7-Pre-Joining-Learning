package com.litmus7.studentdb;

import java.util.*;



public class Student {
	private String Name;
	private int Roll_no;
	private int Marks[]=new int[5];
	
	public void  Input_details(int n) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Student " + n);
		System.out.println("Enter student name:");
		Name=scanner.nextLine();
		
		System.out.println("Enter Roll Number:");
		Roll_no=scanner.nextInt();
		System.out.println("Enter marks for 5 subjects:");
		for(int i=0;i<Marks.length;i++) {
			System.out.println("Subject "+ (i+1) +":");
			Marks[i]=scanner.nextInt();
			if(Marks[i] >100) {
				System.out.println("Invald");
				i--;
			}

		}
		
		
	}

	public int Calculate_total() {
		int total_marks = 0;
		for(int i:Marks) {
			total_marks+=i;
			
		}
		return total_marks;
	}

	public float Calculate_average(int total_marks) {
		float average=0f;
		average=total_marks/5;
		return average;
	}

	public char Get_grade(float average) {
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
				


	 public void Print_reportcard(int total_marks,float average,char grade) {
		 System.out.println("--Report Card--");
		 System.out.println("Name : " + Name);
		 System.out.println("Roll Number : " + Roll_no);
		 System.out.println("Total Marks : " + total_marks );
		 System.out.println("Average Marks : " + average);
		 System.out.println("Grade : " + grade);	 
		 
		  
	 }

	}




	





















