package com.litmus7.studentdetails.dto;

public class Student {
	private String name;
	private int roll_no;
	private float marks[];
 
	public Student() {
		//default constructor
	}
	public Student(String name,int roll_no,float marks[]) {
		this.name=name;   //this.name refers to instance variable
		this.roll_no=roll_no;
		this.marks=marks;
	}
	
	

	public  String getName() {
		
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
public  int getRollno() {
		
		return roll_no;
	}
	public void setRollno(int roll_no) {
		this.roll_no=roll_no;
	}
public  float[] getMarks() {
		
		return marks;
	}
	public void setMarks(float marks[]) {
		this.marks=marks;
	}
 
	
		  
	 }


