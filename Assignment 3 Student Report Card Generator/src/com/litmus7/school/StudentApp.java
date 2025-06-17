package com.litmus7.school;

import java.util.Scanner;

import com.litmus7.studentdb.Student;


public class StudentApp {

	public static void main(String[] args) {
		System .out.println("Enter number of students : ");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Student s[]=new Student[n];
         
		for(int i =0;i<n;i++) {
			s[i]=new Student(); 
			s[i].Input_details(i+1);
	
		int total=s[i].Calculate_total();
		float avg=s[i].Calculate_average(total);
		char grade=s[i].Get_grade(avg);
		s[i].Print_reportcard(total, avg,grade);
		}
		
		
		
		
		
	}


}
